<!-- This file was autogenerated from CircleLayer.tsx do not modify -->

  Mapbox spec: [circle](https://docs.mapbox.com/mapbox-gl-js/style-spec/layers/#circle)
  

```tsx
import { CircleLayer } from '@rnmapbox/maps';

CircleLayer

```
CircleLayer is a style layer that renders one or more filled circles on the map.

## props

  
### id

```tsx
string
```
_required_
A string that uniquely identifies the source in the style to which it is added.


  
### existing

```tsx
boolean
```
The id refers to en existing layer in the style. Does not create a new layer.


  
### sourceID

```tsx
string
```
The source from which to obtain the data to style.
If the source has not yet been added to the current style, the behavior is undefined.
Inferred from parent source only if the layer is a direct child to it.

  _defaults to:_ `MapboxGL.StyleSource.DefaultSourceID`

  
### sourceLayerID

```tsx
string
```
Identifier of the layer within the source identified by the sourceID property
from which the receiver obtains the data to style.


  
### aboveLayerID

```tsx
string
```
Inserts a layer above aboveLayerID.


  
### belowLayerID

```tsx
string
```
Inserts a layer below belowLayerID


  
### layerIndex

```tsx
number
```
Inserts a layer at a specified index


  
### filter

```tsx
FilterExpression
```
Filter only the features in the source layer that satisfy a condition that you define


  
### minZoomLevel

```tsx
number
```
The minimum zoom level at which the layer gets parsed and appears.


  
### maxZoomLevel

```tsx
number
```
The maximum zoom level at which the layer gets parsed and appears.


  
### style

```tsx
CircleLayerStyleProps
```
Customizable style attributes


  






## styles

* <a href="#circlesortkey">circleSortKey</a><br/>
* <a href="#visibility">visibility</a><br/>
* <a href="#circleradius">circleRadius</a><br/>
* <a href="#circlecolor">circleColor</a><br/>
* <a href="#circleblur">circleBlur</a><br/>
* <a href="#circleopacity">circleOpacity</a><br/>
* <a href="#circletranslate">circleTranslate</a><br/>
* <a href="#circletranslateanchor">circleTranslateAnchor</a><br/>
* <a href="#circlepitchscale">circlePitchScale</a><br/>
* <a href="#circlepitchalignment">circlePitchAlignment</a><br/>
* <a href="#circlestrokewidth">circleStrokeWidth</a><br/>
* <a href="#circlestrokecolor">circleStrokeColor</a><br/>
* <a href="#circlestrokeopacity">circleStrokeOpacity</a><br/>

___

### circleSortKey
Name: `circleSortKey`

Mapbox spec: [circle-sort-key](https://docs.mapbox.com/style-spec/reference/layers/#layout-circle-circle-sort-key)

#### Description
Sorts features in ascending order based on this value. Features with a higher sort key will appear above features with a lower sort key.

#### Type
`number`


#### Expression

Parameters: `zoom, feature`

___

### visibility
Name: `visibility`

Mapbox spec: [visibility](https://docs.mapbox.com/style-spec/reference/layers/#layout-circle-visibility)

#### Description
Whether this layer is displayed.

#### Type
`enum`
#### Default Value
`visible`

#### Supported Values
**visible** - The layer is shown.<br />
**none** - The layer is not shown.<br />



___

### circleRadius
Name: `circleRadius`

Mapbox spec: [circle-radius](https://docs.mapbox.com/style-spec/reference/layers/#paint-circle-circle-radius)

#### Description
Circle radius.

#### Type
`number`
#### Default Value
`5`

#### Units
`pixels`

#### Minimum
`0`


#### Expression

Parameters: `zoom, feature, feature-state`
___

### circleRadiusTransition
Name: `circleRadiusTransition`

#### Description

The transition affecting any changes to this layer’s circleRadius property.

#### Type

`{ duration, delay }`

#### Units
`milliseconds`

#### Default Value
`{duration: 300, delay: 0}`


___

### circleColor
Name: `circleColor`

Mapbox spec: [circle-color](https://docs.mapbox.com/style-spec/reference/layers/#paint-circle-circle-color)

#### Description
The fill color of the circle.

#### Type
`color`
#### Default Value
`#000000`


#### Expression

Parameters: `zoom, feature, feature-state`
___

### circleColorTransition
Name: `circleColorTransition`

#### Description

The transition affecting any changes to this layer’s circleColor property.

#### Type

`{ duration, delay }`

#### Units
`milliseconds`

#### Default Value
`{duration: 300, delay: 0}`


___

### circleBlur
Name: `circleBlur`

Mapbox spec: [circle-blur](https://docs.mapbox.com/style-spec/reference/layers/#paint-circle-circle-blur)

#### Description
Amount to blur the circle. 1 blurs the circle such that only the centerpoint is full opacity.

#### Type
`number`
#### Default Value
`0`


#### Expression

Parameters: `zoom, feature, feature-state`
___

### circleBlurTransition
Name: `circleBlurTransition`

#### Description

The transition affecting any changes to this layer’s circleBlur property.

#### Type

`{ duration, delay }`

#### Units
`milliseconds`

#### Default Value
`{duration: 300, delay: 0}`


___

### circleOpacity
Name: `circleOpacity`

Mapbox spec: [circle-opacity](https://docs.mapbox.com/style-spec/reference/layers/#paint-circle-circle-opacity)

#### Description
The opacity at which the circle will be drawn.

#### Type
`number`
#### Default Value
`1`

#### Minimum
`0`


#### Maximum
`1`

#### Expression

Parameters: `zoom, feature, feature-state`
___

### circleOpacityTransition
Name: `circleOpacityTransition`

#### Description

The transition affecting any changes to this layer’s circleOpacity property.

#### Type

`{ duration, delay }`

#### Units
`milliseconds`

#### Default Value
`{duration: 300, delay: 0}`


___

### circleTranslate
Name: `circleTranslate`

Mapbox spec: [circle-translate](https://docs.mapbox.com/style-spec/reference/layers/#paint-circle-circle-translate)

#### Description
The geometry's offset. Values are [x, y] where negatives indicate left and up, respectively.

#### Type
`array<number>`
#### Default Value
`[0,0]`

#### Units
`pixels`


#### Expression

Parameters: `zoom`
___

### circleTranslateTransition
Name: `circleTranslateTransition`

#### Description

The transition affecting any changes to this layer’s circleTranslate property.

#### Type

`{ duration, delay }`

#### Units
`milliseconds`

#### Default Value
`{duration: 300, delay: 0}`


___

### circleTranslateAnchor
Name: `circleTranslateAnchor`

Mapbox spec: [circle-translate-anchor](https://docs.mapbox.com/style-spec/reference/layers/#paint-circle-circle-translate-anchor)

#### Description
Controls the frame of reference for `circleTranslate`.

#### Type
`enum`
#### Default Value
`map`

#### Supported Values
**map** - The circle is translated relative to the map.<br />
**viewport** - The circle is translated relative to the viewport.<br />


#### Requires
`circleTranslate`

#### Expression

Parameters: `zoom`

___

### circlePitchScale
Name: `circlePitchScale`

Mapbox spec: [circle-pitch-scale](https://docs.mapbox.com/style-spec/reference/layers/#paint-circle-circle-pitch-scale)

#### Description
Controls the scaling behavior of the circle when the map is pitched.

#### Type
`enum`
#### Default Value
`map`

#### Supported Values
**map** - Circles are scaled according to their apparent distance to the camera.<br />
**viewport** - Circles are not scaled.<br />


#### Expression

Parameters: `zoom`

___

### circlePitchAlignment
Name: `circlePitchAlignment`

Mapbox spec: [circle-pitch-alignment](https://docs.mapbox.com/style-spec/reference/layers/#paint-circle-circle-pitch-alignment)

#### Description
Orientation of circle when map is pitched.

#### Type
`enum`
#### Default Value
`viewport`

#### Supported Values
**map** - The circle is aligned to the plane of the map.<br />
**viewport** - The circle is aligned to the plane of the viewport.<br />


#### Expression

Parameters: `zoom`

___

### circleStrokeWidth
Name: `circleStrokeWidth`

Mapbox spec: [circle-stroke-width](https://docs.mapbox.com/style-spec/reference/layers/#paint-circle-circle-stroke-width)

#### Description
The width of the circle's stroke. Strokes are placed outside of the `circleRadius`.

#### Type
`number`
#### Default Value
`0`

#### Units
`pixels`

#### Minimum
`0`


#### Expression

Parameters: `zoom, feature, feature-state`
___

### circleStrokeWidthTransition
Name: `circleStrokeWidthTransition`

#### Description

The transition affecting any changes to this layer’s circleStrokeWidth property.

#### Type

`{ duration, delay }`

#### Units
`milliseconds`

#### Default Value
`{duration: 300, delay: 0}`


___

### circleStrokeColor
Name: `circleStrokeColor`

Mapbox spec: [circle-stroke-color](https://docs.mapbox.com/style-spec/reference/layers/#paint-circle-circle-stroke-color)

#### Description
The stroke color of the circle.

#### Type
`color`
#### Default Value
`#000000`


#### Expression

Parameters: `zoom, feature, feature-state`
___

### circleStrokeColorTransition
Name: `circleStrokeColorTransition`

#### Description

The transition affecting any changes to this layer’s circleStrokeColor property.

#### Type

`{ duration, delay }`

#### Units
`milliseconds`

#### Default Value
`{duration: 300, delay: 0}`


___

### circleStrokeOpacity
Name: `circleStrokeOpacity`

Mapbox spec: [circle-stroke-opacity](https://docs.mapbox.com/style-spec/reference/layers/#paint-circle-circle-stroke-opacity)

#### Description
The opacity of the circle's stroke.

#### Type
`number`
#### Default Value
`1`

#### Minimum
`0`


#### Maximum
`1`

#### Expression

Parameters: `zoom, feature, feature-state`
___

### circleStrokeOpacityTransition
Name: `circleStrokeOpacityTransition`

#### Description

The transition affecting any changes to this layer’s circleStrokeOpacity property.

#### Type

`{ duration, delay }`

#### Units
`milliseconds`

#### Default Value
`{duration: 300, delay: 0}`


