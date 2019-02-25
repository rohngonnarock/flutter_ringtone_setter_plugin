import 'package:flutter/material.dart';
import 'dart:async';

import 'package:flutter/services.dart';
import 'package:ringtone_setter/ringtone_setter.dart';

void main() => runApp(MyApp());

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  @override
  Widget build(BuildContext context) {
    return new MaterialApp(
      home: new Scaffold(
        appBar: new AppBar(
          title: const Text('Plugin ringtone app'),
        ),
        body: new Center(
          child: new Text('Ringtone'),
        ),
        persistentFooterButtons: <Widget>[
          new FlatButton(
            onPressed: () {
              RingtoneSetter.stop("test");
            },
            child: const Text('Stop')
          ),
          new FlatButton(
            onPressed: () {
              RingtoneSetter.play("test");
            },
            child: const Text('Play')
          ),
        ],
      ),
    );
  }
}