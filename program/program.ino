#include <Servo.h>

int pos = 0;
String command;
String PreCommand;
int Angle = 0;
int Delay = 50;
int Angle1=90;
int Angle2=0;
int Angle3=0;
int Angle4=90;
Servo Podstawa;
Servo PierwszaCzescRamienia;
Servo DrugaCzescRamienia;
Servo Uchwyt;

void setup()
{
  Serial.begin(9600); 
  Podstawa.attach(8);
  PierwszaCzescRamienia.attach(9);
  DrugaCzescRamienia.attach(10);
  Uchwyt.attach(11);
  PreCommand="";
  Reset();
}

void loop()
{
     if(Serial.available()){
        command = Serial.readStringUntil('\n');
         PreCommand = command.substring(0, 2);
       Angle = TakeAngleFromCommand(command);
        if(command.equals("RESET")){
           Reset();
        }
        else if(PreCommand.equals("DL")){
            SetDelay(Angle);
        }
        else if(PreCommand.equals("1L")){
            RuszPodstawe(Angle, true);
        }
        else if(PreCommand.equals("1R")){
            RuszPodstawe(Angle, false);
        }
        else if(PreCommand.equals("2G")){
            RuszPierwczaCzesc(Angle, true);
        }
        else if(PreCommand.equals("2D")){
            RuszPierwczaCzesc(Angle, false);
        }
        else if(PreCommand.equals("3G")){
            RuszDrugaCzesc(Angle, true);
        }
        else if(PreCommand.equals("3D")){
            RuszDrugaCzesc(Angle, false);
        }
        else if(PreCommand.equals("4G")){
            RuszUchwyt(Angle, true);
        }
        else if(PreCommand.equals("4D")){
            RuszUchwyt(Angle, false);
        }
    }
  command="";
  PreCommand="";
  Angle=0;
}
//Pobiera numer z komendy np 1L20 to pobierze 20, jesli sie nie udalo, zwraca 0
int TakeAngleFromCommand(String com) 
{
  String num = com.substring(2);
     boolean isNum=false;
   for(byte i=0;i<num.length();i++)
   {
       isNum = isDigit(num.charAt(i));
       if(!isNum)
       {
         return 0;
       }
   }
  return num.toInt();
}
void Reset()
{
  Podstawa.write(90);
  PierwszaCzescRamienia.write(0);
  DrugaCzescRamienia.write(0);
  Uchwyt.write(90);
  Angle1=90;
  Angle2=0;
  Angle3=0;
  Angle4=90;
}
void RuszPodstawe(int kat, bool lewo)
{
  
  for(int i=0; i<kat; i++)
  {

    if(lewo)
    {
      if(Angle1>=180) //max granica
      {
        Angle1=180;
        return;
      }
      Angle1+=1;
      Podstawa.write(Angle1);
    }
    else
    {
      if(Angle1<=0) //min granica
      {
        Angle1=0;
        return;
      }
      Angle1-=1;
      Podstawa.write(Angle1);
    }
    delay(Delay);
  }

}
void RuszPierwczaCzesc(int kat, bool gora)
{
  for(int i=0; i<kat; i++)
  {

    if(gora)
    {
      if(Angle2>=150)
      {
        Angle2=150;
        return;
      }
      Angle2+=1;
      PierwszaCzescRamienia.write(Angle2);
    }
    else
    {
      if(Angle2<=0)
      {
        Angle2=0;
        return;
      }
      Angle2-=1;
      PierwszaCzescRamienia.write(Angle2);
    }
    delay(Delay);
  }
}
void RuszDrugaCzesc(int kat, bool gora)
{
  for(int i=0; i<kat; i++)
  {

    if(gora)
    {  
      if(Angle3>=140)
      {
        Angle3=140;
        return;
      }
      Angle3+=1;
      DrugaCzescRamienia.write(Angle3);
    }
    else
    {      
      if(Angle3<=0)
      {
        Angle3=0;
        return;
      }
      Angle3-=1;
      DrugaCzescRamienia.write(Angle3);
    }
    delay(Delay);
  }
}
void RuszUchwyt(int kat, bool gora)
{
  for(int i=0; i<kat; i++)
  {

    if(gora)
    {      
      if(Angle4>=180)
      {
        Angle4=180;
        return;
      }
      Angle4+=1;
      Uchwyt.write(Angle4);
    }
    else
    {      
      if(Angle4<=0)
      {
        Angle4=0;
        return;
      }
      Angle4-=1;
      Uchwyt.write(Angle4);
    }
    delay(Delay);
  }
}
void SetDelay(int opoznienie)
{
  //if(opoznienie>TU_WPISZ_MAX)
  //{
  //  opoznienie = TU_WPISZ_MAX;
  //}
  //  if(opoznienie<TU_WPISZ_MIN)
  //{
  //  opoznienie = TU_WPISZ_MIN;
  //}
    Delay=opoznienie;
}
