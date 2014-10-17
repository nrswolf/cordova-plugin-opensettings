//
//  Created by Erik Huisman
//

#import "OpenSettings.h"
#import <Cordova/CDV.h>

@implementation OpenSettings

-(void) open:(CDVInvokedUrlCommand*)command {

    CDVPluginResult* pluginResult = nil;

    [[UIApplication sharedApplication] openURL:[NSURL URLWithString:UIApplicationOpenSettingsURLString]];

    // TODO check if is iOS8 otherwise error
    pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsBool:result];

    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

@end
