import 'dart:async';

import 'package:flutter/services.dart';

class RingtoneSetter {
  static const MethodChannel _channel =
      const MethodChannel('ringtone_setter');

  static Future play(name) => _channel.invokeMethod('play', {"name" :name});

  static Future stop(name) => _channel.invokeMethod('stop', {"name" :name});

}
