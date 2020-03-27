import 'package:flutter/material.dart';
import 'PantallaMC.dart';

void main() => runApp(MyApp());


class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'IMC Calculadora',
      theme: ThemeData(
        primarySwatch: Colors.lightGreen,
      ),
      home: PantallaIMCStateful(),
      debugShowCheckedModeBanner: false,
    );
  }
}