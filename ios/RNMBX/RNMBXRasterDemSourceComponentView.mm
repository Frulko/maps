#ifdef RCT_NEW_ARCH_ENABLED

#import "RNMBXRasterDemSourceComponentView.h"
#import "RNMBXFabricHelpers.h"

#import <React/RCTConversions.h>
#import <React/RCTFabricComponentsPlugins.h>

#import <react/renderer/components/rnmapbox_maps_specs/ComponentDescriptors.h>
#import <react/renderer/components/rnmapbox_maps_specs/EventEmitters.h>
#import <react/renderer/components/rnmapbox_maps_specs/Props.h>
#import <react/renderer/components/rnmapbox_maps_specs/RCTComponentViewHelpers.h>

using namespace facebook::react;

@interface RNMBXRasterDemSourceComponentView () <RCTRNMBXRasterDemSourceViewProtocol>
@end

@implementation RNMBXRasterDemSourceComponentView {
    RNMBXRasterDemSource *_view;
}

@synthesize mapFeature;

- (instancetype)initWithFrame:(CGRect)frame
{
  if (self = [super initWithFrame:frame]) {
    static const auto defaultProps = std::make_shared<const RNMBXRasterDemSourceProps>();
    _props = defaultProps;
    [self prepareView];
  }

  return self;
}

- (void)prepareView
{
  _view =  [[RNMBXRasterDemSource alloc] init];
  self.contentView = _view;
  self.mapFeature = _view;
}

- (void)prepareForRecycle
{
    [super prepareForRecycle];
    [self prepareView];
}

- (void)mountChildComponentView:(UIView<RCTComponentViewProtocol> *)childComponentView index:(NSInteger)index
{
    if ([childComponentView isKindOfClass:[RCTViewComponentView class]]) {
        [_view insertReactSubviewInternal:((RCTViewComponentView *)childComponentView).contentView at:index];
    } else {
        RCTLogError(@"Tried to add view that is not RCTViewComponentView: %@", childComponentView);
    }
}

- (void)unmountChildComponentView:(UIView<RCTComponentViewProtocol> *)childComponentView index:(NSInteger)index
{
    if ([childComponentView isKindOfClass:[RCTViewComponentView class]]) {
        [_view removeReactSubviewInternal:((RCTViewComponentView *)childComponentView).contentView];
    } else {
        RCTLogError(@"Tried to remove view that is not RCTViewComponentView: %@", childComponentView);
    }
}

#pragma mark - RCTComponentViewProtocol

+ (ComponentDescriptorProvider)componentDescriptorProvider
{
  return concreteComponentDescriptorProvider<RNMBXRasterDemSourceComponentDescriptor>();
}

- (void)updateProps:(const Props::Shared &)props oldProps:(const Props::Shared &)oldProps
{
  const auto &newProps = *std::static_pointer_cast<const RNMBXRasterDemSourceProps>(props);
    id idx = RNMBXConvertFollyDynamicToId(newProps.id);
    if (idx != nil) {
        _view.id = idx;
    }
    id existing = RNMBXConvertFollyDynamicToId(newProps.existing);
    if (existing != nil) {
        _view.existing = existing;
    }
    id url = RNMBXConvertFollyDynamicToId(newProps.url);
    if (url != nil) {
        _view.url = url;
    }
    id tileUrlTemplates = RNMBXConvertFollyDynamicToId(newProps.tileUrlTemplates);
    if (tileUrlTemplates != nil) {
        _view.tileUrlTemplates = tileUrlTemplates;
    }
    id minZoomLevel = RNMBXConvertFollyDynamicToId(newProps.minZoomLevel);
    if (minZoomLevel != nil) {
        _view.minZoomLevel = minZoomLevel;
    }
    id maxZoomLevel = RNMBXConvertFollyDynamicToId(newProps.maxZoomLevel);
    if (maxZoomLevel != nil) {
        _view.maxZoomLevel = maxZoomLevel;
    }
    id tileSize = RNMBXConvertFollyDynamicToId(newProps.tileSize);
    if (tileSize != nil) {
        _view.tileSize = tileSize;
    }
    
  [super updateProps:props oldProps:oldProps];
}

@end

Class<RCTComponentViewProtocol> RNMBXRasterDemSourceCls(void)
{
  return RNMBXRasterDemSourceComponentView.class;
}

#endif // RCT_NEW_ARCH_ENABLED
