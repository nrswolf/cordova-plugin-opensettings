//
//  Created by Erik Huisman
//

#import <Cordova/CDV.h>
#import <CoreBluetooth/CoreBluetooth.h>

@interface OpenSettings : CDVPlugin

- (void)settings:(CDVInvokedUrlCommand*)command;
- (void)bluetooth:(CDVInvokedUrlCommand*)command;

@end
