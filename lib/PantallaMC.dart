import 'IMCModelo.dart';
import 'ResultadoIMC.dart';
import 'package:flutter/material.dart';
import 'package:flutter_svg/flutter_svg.dart';

class PantallaIMCStateful extends StatefulWidget {
  @override
  _PantallaIMCState createState() => _PantallaIMCState();
}

class _PantallaIMCState extends State<PantallaIMCStateful> {
  double _alturaUsuario = 100.0;
  double _pesoUsuario = 40.0;
  double _imc = 0;

  IMCModelo _IMCModelo;
  double peso, altura;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SingleChildScrollView(
        child: Container(
          width: double.infinity,
          padding: EdgeInsets.all(32),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.center,
            children: <Widget>[
              Container(
                height: 200,
                width: 200,
                child: SvgPicture.asset("assets/images/neutral.svg", fit: BoxFit.contain,),
              ),
              SizedBox(
                height: 8,
              ),
              Text("IMC", style: TextStyle(color: Colors.lightGreen, fontSize: 34, fontWeight: FontWeight.w700),),
              Text("Nos preocupa tu salud", style: TextStyle(color: Colors.lightBlue, fontSize: 15, fontWeight: FontWeight.w400),),
              SizedBox(
                height: 32,
              ),

              Text("Altura (cm)", style: TextStyle(color: Colors.lightBlue, fontSize: 24, fontWeight: FontWeight.w400),),

              Container(
                padding: EdgeInsets.only(left: 16, right: 16),
                child: Slider(
                  min: 80.0,
                  max: 250.0,
                  onChanged: (height){
                    setState(() {
                      _alturaUsuario = height;
                      this.altura = height;
                    });
                  },
                  value: _alturaUsuario,
                  divisions: 100,
                  activeColor: Colors.lime,
                  label: "$_alturaUsuario",
                ),
              ),

              Text("$_alturaUsuario cm", style: TextStyle(color: Colors.lightGreen, fontSize: 18, fontWeight: FontWeight.w900),),

              SizedBox(height: 24,),

              Text("Peso (kg)", style: TextStyle(color: Colors.lightBlue, fontSize: 24, fontWeight: FontWeight.w400),),

              Container(
                padding: EdgeInsets.only(left: 16, right: 16),
                child: Slider(
                  min: 30.0,
                  max: 120.0,
                  onChanged: (height){
                    setState(() {
                      _pesoUsuario = height;
                      this.peso = height;
                    });
                  },
                  value: _pesoUsuario,
                  divisions: 100,
                  activeColor: Colors.lime,
                  label: "$_pesoUsuario",
                ),
              ),

              Text("$_pesoUsuario kg", style: TextStyle(color: Colors.lightGreen, fontSize: 18, fontWeight: FontWeight.w900),),

              SizedBox(height: 16,),

              Container(
                child: FlatButton.icon(
                  onPressed: (){
                    setState(() {
                      double IMC = _pesoUsuario/((_alturaUsuario/100)*(_alturaUsuario/100));
                      if(IMC < 18.5){
                        _IMCModelo = IMCModelo(imc: IMC, esNormal: false, resultado: "Tienes peso de menos al indicado");
                      }else if(IMC < 24.9){
                        _IMCModelo = IMCModelo(imc: IMC, esNormal: true, resultado: "Te encuentras en el promedio");
                      }else if(IMC > 24.9){
                        _IMCModelo = IMCModelo(imc: IMC, esNormal: false, resultado: "Tienes sobrepeso");
                      }else{
                        _IMCModelo = IMCModelo(imc: IMC, esNormal: false, resultado: "Error");
                      }
                    });
                    Navigator.push(context, MaterialPageRoute(
                        builder: (context) => ResultadoIMC(imcModelo: _IMCModelo,)
                    ));
                  },
                  icon: Icon(Icons.favorite, color: Colors.white,),
                  label: Text("Mide tu IMC"),
                  textColor: Colors.white,
                  color: Colors.lime,

                ),
                width: double.infinity,
                padding: EdgeInsets.only(left: 16, right: 16),
              )
            ],
          ),
        ),
      ),
    );
  }
}