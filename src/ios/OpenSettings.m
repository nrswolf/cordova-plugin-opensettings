//
//  Created by Erik Huisman
//

#import "OpenSettings.h"

@implementation OpenSettings

-(void) settings:(CDVInvokedUrlCommand*)command {

  CDVPluginResult* pluginResult = nil;

  [[UIApplication sharedApplication] openURL:[NSURL URLWithString:UIApplicationOpenSettingsURLString]];

  // TODO check if is iOS8 otherwise error
  pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK];

  [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

@end
