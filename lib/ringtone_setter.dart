import 'dart:async';

import 'package:flutter/services.dart';

class RingtoneSetter {
  static const MethodChannel _channel =
      const MethodChannel('ringtone_setter');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }
}
