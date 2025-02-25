<!-- This file was autogenerated from HeatmapLayer.tsx do not modify -->

  Mapbox spec: [heatmap](https://docs.mapbox.com/mapbox-gl-js/style-spec/layers/#heatmap)
  

```tsx
import { HeatmapLayer } from '@rnmapbox/maps';

HeatmapLayer

```
HeatmapLayer is a style layer that renders one or more filled circles on the map.

## props

  
### id

```tsx
string
```
_required_
A string that uniquely identifies the layer in the style to which it is added.


  
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
HeatmapLayerStyleProps
```
Customizable style attributes


  






## styles

* <a href="#visibility">visibility</a><br/>
* <a href="#heatmapradius">heatmapRadius</a><br/>
* <a href="#heatmapweight">heatmapWeight</a><br/>
* <a href="#heatmapintensity">heatmapIntensity</a><br/>
* <a href="#heatmapcolor">heatmapColor</a><br/>
* <a href="#heatmapopacity">heatmapOpacity</a><br/>

___

### visibility
Name: `visibility`

Mapbox spec: [visibility](https://docs.mapbox.com/style-spec/reference/layers/#layout-heatmap-visibility)

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

### heatmapRadius
Name: `heatmapRadius`

Mapbox spec: [heatmap-radius](https://docs.mapbox.com/style-spec/reference/layers/#paint-heatmap-heatmap-radius)

#### Description
Radius of influence of one heatmap point in pixels. Increasing the value makes the heatmap smoother, but less detailed. `queryRenderedFeatures` on heatmap layers will return points within this radius.

#### Type
`number`
#### Default Value
`30`

#### Units
`pixels`

#### Minimum
`1`


#### Expression

Parameters: `zoom, feature, feature-state`
___

### heatmapRadiusTransition
Name: `heatmapRadiusTransition`

#### Description

The transition affecting any changes to this layer’s heatmapRadius property.

#### Type

`{ duration, delay }`

#### Units
`milliseconds`

#### Default Value
`{duration: 300, delay: 0}`


___

### heatmapWeight
Name: `heatmapWeight`

Mapbox spec: [heatmap-weight](https://docs.mapbox.com/style-spec/reference/layers/#paint-heatmap-heatmap-weight)

#### Description
A measure of how much an individual point contributes to the heatmap. A value of 10 would be equivalent to having 10 points of weight 1 in the same spot. Especially useful when combined with clustering.

#### Type
`number`
#### Default Value
`1`

#### Minimum
`0`


#### Expression

Parameters: `zoom, feature, feature-state`

___

### heatmapIntensity
Name: `heatmapIntensity`

Mapbox spec: [heatmap-intensity](https://docs.mapbox.com/style-spec/reference/layers/#paint-heatmap-heatmap-intensity)

#### Description
Similar to `heatmapWeight` but controls the intensity of the heatmap globally. Primarily used for adjusting the heatmap based on zoom level.

#### Type
`number`
#### Default Value
`1`

#### Minimum
`0`


#### Expression

Parameters: `zoom`
___

### heatmapIntensityTransition
Name: `heatmapIntensityTransition`

#### Description

The transition affecting any changes to this layer’s heatmapIntensity property.

#### Type

`{ duration, delay }`

#### Units
`milliseconds`

#### Default Value
`{duration: 300, delay: 0}`


___

### heatmapColor
Name: `heatmapColor`

Mapbox spec: [heatmap-color](https://docs.mapbox.com/style-spec/reference/layers/#paint-heatmap-heatmap-color)

#### Description
Defines the color of each pixel based on its density value in a heatmap.  Should be an expression that uses `["heatmapDensity"]` as input.

#### Type
`color`
#### Default Value
`interpolate,linear,heatmap-density,0,rgba(0, 0, 255, 0),0.1,royalblue,0.3,cyan,0.5,lime,0.7,yellow,1,red`


#### Expression

Parameters: `heatmap-density`

___

### heatmapOpacity
Name: `heatmapOpacity`

Mapbox spec: [heatmap-opacity](https://docs.mapbox.com/style-spec/reference/layers/#paint-heatmap-heatmap-opacity)

#### Description
The global opacity at which the heatmap layer will be drawn.

#### Type
`number`
#### Default Value
`1`

#### Minimum
`0`


#### Maximum
`1`

#### Expression

Parameters: `zoom`
___

### heatmapOpacityTransition
Name: `heatmapOpacityTransition`

#### Description

The transition affecting any changes to this layer’s heatmapOpacity property.

#### Type

`{ duration, delay }`

#### Units
`milliseconds`

#### Default Value
`{duration: 300, delay: 0}`


