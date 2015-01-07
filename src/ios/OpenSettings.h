//
//  Created by Erik Huisman
//

#import <Cordova/CDV.h>
#import <CoreBluetooth/CoreBluetooth.h>

@interface OpenSettings : CDVPlugin<CBPeripheralManagerDelegate> { }
@property (retain) CBPeripheralManager *peripheralManager;

- (void)settings:(CDVInvokedUrlCommand*)command;
- (void)bluetooth:(CDVInvokedUrlCommand*)command;
- (void)bluetoothStatus:(CDVInvokedUrlCommand*)command;

@end
