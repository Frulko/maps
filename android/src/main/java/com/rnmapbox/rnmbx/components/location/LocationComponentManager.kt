package com.rnmapbox.rnmbx.components.location

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.VectorDrawable
import androidx.appcompat.content.res.AppCompatResources
import androidx.lifecycle.Lifecycle
import com.mapbox.maps.plugin.locationcomponent.location
import com.rnmapbox.rnmbx.components.mapview.RNMBXMapView
import com.mapbox.maps.plugin.LocationPuck2D
import com.mapbox.maps.plugin.lifecycle.lifecycle
import com.rnmapbox.rnmbx.R
import com.rnmapbox.rnmbx.location.LocationManager

import com.rnmapbox.rnmbx.v11compat.location.PuckBearingSource;
import com.rnmapbox.rnmbx.v11compat.image.*;

/**
 * The LocationComponent on android implements display of user's current location.
 * But viewport seems to be tied to it in the sense that if location is not enabled then it's viewport user tracking is not working.
 * LocationComponentManager attempts to separate that, so that Camera can ask for location tracking independent of display of user current location.
 * And NativeUserLocation can ask for display of user's current location - independent of Camera's user tracking.
 */
class LocationComponentManager(mapView: RNMBXMapView, context: Context) {
    var mMapView = mapView
    var mContext = context
    private var mState = State(showUserLocation=false, followUserLocation=false, tintColor= null, bearingImage = null, puckBearingSource =null)

    private var mLocationManager: LocationManager = LocationManager.getInstance(context)

    private var mNeedsFullUpdate = true

    private var mLocationManagerStarted = false

    data class State(
        val showUserLocation: Boolean,
        val followUserLocation: Boolean,
        val tintColor: Int?, // tint of location puck
        var bearingImage: ImageHolder?, // bearing image (background)
        var puckBearingSource: PuckBearingSource? // bearing source
    ) {
        val enabled: Boolean
            get() = showUserLocation || followUserLocation

        val hidden: Boolean
            get() = followUserLocation && !showUserLocation
    }

    fun update(newStateCallback: (currentState: State) -> State) {
        val newState = newStateCallback(mState);
        if (newState != mState) {
            applyStateChanges(mState, newState)
            mState = newState
        }
    }

    private fun applyStateChanges(oldState: State, newState: State) {
        mMapView.let {
            val needsFullUpdate = mNeedsFullUpdate

            applyStateChanges(it, oldState, newState,  needsFullUpdate)

            mNeedsFullUpdate = false
        }
    }

    private fun applyStateChanges(map: RNMBXMapView, oldState: State, newState: State, fullUpdate: Boolean) {
        val mapView = map.mapView
        if (map.getLifecycleState() != Lifecycle.State.STARTED && map.getLifecycleState() != Lifecycle.State.INITIALIZED) {
            // In case lifecycle was already stopped, so we're part of shutdown, do not call updateSettings as it'll just restart
            // the loationComponent that will not be stopped. See https://github.com/mapbox/mapbox-maps-android/issues/2017
            if (!newState.enabled) {
                stopLocationManager()
            }
            return
        }
        mapView.location.updateSettings {
            enabled = newState.enabled

            if (fullUpdate || (newState.hidden != oldState.hidden) || (newState.tintColor != oldState.tintColor) || (newState.bearingImage != oldState.bearingImage)) {
                if (newState.hidden) {
                    var emptyLocationPuck = LocationPuck2D()
                    val empty = AppCompatResourcesV11.getDrawableImageHolder(mContext, R.drawable.empty)
                    emptyLocationPuck.bearingImage = empty
                    emptyLocationPuck.shadowImage = empty
                    emptyLocationPuck.topImage = empty
                    //emptyLocationPuck.opacity = 0.0
                    locationPuck = emptyLocationPuck
                    pulsingEnabled = false
                } else {
                    val mapboxBlueColor = Color.parseColor("#4A90E2")
                    val tintColor = newState.tintColor
                    val defaultLocationPuck = LocationPuck2D()
                    var topImage = AppCompatResourcesV11.getDrawableImageHolder(mContext, R.drawable.mapbox_user_icon)
                    if (tintColor != null) {
                        val drawable = AppCompatResources.getDrawable(mContext, R.drawable.mapbox_user_icon) as VectorDrawable?
                        drawable!!.setTint(tintColor)
                        topImage = drawable.toBitmapImageHolder()
                    }
                    defaultLocationPuck.topImage = topImage
                    val defaultBearingImage = AppCompatResourcesV11.getDrawableImageHolder(
                        mContext, R.drawable.mapbox_user_stroke_icon
                    )
                    defaultLocationPuck.bearingImage = newState.bearingImage ?: defaultBearingImage
                    val shadowImage = AppCompatResourcesV11.getDrawableImageHolder(
                        mContext, R.drawable.mapbox_user_icon_shadow
                    )
                    defaultLocationPuck.shadowImage = shadowImage
                    locationPuck = defaultLocationPuck
                    pulsingEnabled = true
                    if (tintColor != null) {
                        pulsingColor = tintColor
                    } else {
                        pulsingColor = mapboxBlueColor
                    }
                }
            }

            if (fullUpdate || newState.enabled != mState.enabled) {
                if (newState.enabled) {
                    startLocationManager()
                    useMapLocationProvider(map)
                } else {
                    stopLocationManager()
                }
            }
        }
    }

    private fun startLocationManager() {
        if (!mLocationManagerStarted) {
            mLocationManager.startCounted()
            mLocationManagerStarted = true
        }
    }

    private fun stopLocationManager() {
        if (mLocationManagerStarted) {
            mLocationManager.stopCounted()
            mLocationManagerStarted = false
        }
    }

    private fun useMapLocationProvider(mapView: RNMBXMapView) {
        val provider = mapView.mapView.location.getLocationProvider()
        if (provider != null) {
            mLocationManager.provider = provider
        }
    }


    fun showNativeUserLocation(showUserLocation: Boolean) {
        update {
            it.copy(showUserLocation = showUserLocation)
        }
    }

    fun setFollowLocation(followUserLocation: Boolean) {
        update {
            it.copy(followUserLocation = followUserLocation)
        }
    }

    fun update() {
        update { it }
    }

    fun onDestroy() {
        stopLocationManager();
    }
}