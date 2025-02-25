<!-- This file was autogenerated from ShapeSource.tsx do not modify -->

  

```tsx
import { ShapeSource } from '@rnmapbox/maps';

ShapeSource

```
ShapeSource is a map content source that supplies vector shapes to be shown on the map.
The shape may be an url or a GeoJSON object

## props

  
### id

```tsx
string
```
A string that uniquely identifies the source.

  _defaults to:_ `MapboxGL.StyleSource.DefaultSourceID`

  
### existing

```tsx
boolean
```
The id refers to en existing source in the style. Does not create a new source.


  
### url

```tsx
string
```
An HTTP(S) URL, absolute file URL, or local file URL relative to the current application’s resource bundle.


  
### shape

```tsx
| GeoJSON.GeometryCollection
| GeoJSON.Feature
| GeoJSON.FeatureCollection
| GeoJSON.Geometry
```
The contents of the source. A shape can represent a GeoJSON geometry, a feature, or a feature collection.


  
### cluster

```tsx
boolean
```
Enables clustering on the source for point shapes.


  
### clusterRadius

```tsx
number
```
Specifies the radius of each cluster if clustering is enabled.
A value of 512 produces a radius equal to the width of a tile.
The default value is 50.


  
### clusterMaxZoomLevel

```tsx
number
```
Specifies the maximum zoom level at which to cluster points if clustering is enabled.
Defaults to one zoom level less than the value of maxZoomLevel so that, at the maximum zoom level,
the shapes are not clustered.


  
### clusterProperties

```tsx
object
```
[`mapbox-gl` (v8) implementation only]
Specifies custom properties on the generated clusters if clustering
is enabled, aggregating values from clustered points.

Has the form `{ "property_name": [operator, map_expression]}`, where
 `operator` is a custom reduce expression that references a special `["accumulated"]` value -
  it accumulates the property value from clusters/points the cluster contains
 `map_expression` produces the value of a single point

Example: `{ "resultingSum": [["+", ["accumulated"], ["get", "resultingSum"]], ["get", "scalerank"]] }`


  
### maxZoomLevel

```tsx
number
```
Specifies the maximum zoom level at which to create vector tiles.
A greater value produces greater detail at high zoom levels.
The default value is 18.


  
### buffer

```tsx
number
```
Specifies the size of the tile buffer on each side.
A value of 0 produces no buffer. A value of 512 produces a buffer as wide as the tile itself.
Larger values produce fewer rendering artifacts near tile edges and slower performance.
The default value is 128.


  
### tolerance

```tsx
number
```
Specifies the Douglas-Peucker simplification tolerance.
A greater value produces simpler geometries and improves performance.
The default value is 0.375.


  
### lineMetrics

```tsx
boolean
```
Whether to calculate line distance metrics.
This is required for line layers that specify lineGradient values.
The default value is false.


  
### onPress

```tsx
func
```
Source press listener, gets called when a user presses one of the children layers only
if that layer has a higher z-index than another source layers

@param {Object} event
@param {Object[]} event.features - the geojson features that have hit by the press (might be multiple)
@param {Object} event.coordinates - the coordinates of the click
@param {Object} event.point - the point of the click
@return void
*signature:*`(event:OnPressEvent) =&gt; void`

[Custom Icon](../examples/SymbolCircleLayer/CustomIcon)
  
### hitbox

```tsx
type Hitbox = {
  width: number; /* `width` of hitbox */
  height: number; /* `height` of hitbox */
}
```
Overrides the default touch hitbox(44x44 pixels) for the source layers


  
### children

```tsx
React.ReactElement | React.ReactElement[]
```
FIX ME NO DESCRIPTION


  





## methods
### getClusterExpansionZoom(feature)

Returns the zoom needed to expand the cluster.

#### arguments
| Name | Type | Required | Description  |
| ---- | :--: | :------: | :----------: |
| `feature` | `string \| GeoJSON.Feature` | `Yes` | The feature cluster to expand. |



```javascript
const zoom = await shapeSource.getClusterExpansionZoom(clusterId);
```


### getClusterLeaves(feature, limit, offset)

Returns the FeatureCollection from the cluster.

#### arguments
| Name | Type | Required | Description  |
| ---- | :--: | :------: | :----------: |
| `feature` | `number \| GeoJSON.Feature` | `Yes` | The feature cluster to expand. |
| `limit` | `number` | `Yes` | The number of points to return. |
| `offset` | `number` | `Yes` | The amount of points to skip (for pagination). |



```javascript
const collection = await shapeSource.getClusterLeaves(clusterId, limit, offset);
```


[Earthquakes](../examples/SymbolCircleLayer/Earthquakes)### getClusterChildren(feature)

Returns the FeatureCollection from the cluster (on the next zoom level).

#### arguments
| Name | Type | Required | Description  |
| ---- | :--: | :------: | :----------: |
| `feature` | `number \| GeoJSON.Feature` | `Yes` | The feature cluster to expand. |



```javascript
const collection = await shapeSource.getClusterChildren(clusterId);
```


### onPress(event)



#### arguments
| Name | Type | Required | Description  |
| ---- | :--: | :------: | :----------: |
| `event` | `NativeSyntheticEvent` | `Yes` | undefined |


[Custom Icon](../examples/SymbolCircleLayer/CustomIcon)
