//Programa de una agenda
#include<stdio.h>
#include<conio.h>
#include<iostream>
#include<windows.h>
using namespace std;
void gotoxy(int x, int y){
	HANDLE hcon=GetStdHandle(STD_OUTPUT_HANDLE);
	COORD dwPos;
	dwPos.X=x;
	dwPos.Y=y;
	SetConsoleCursorPosition(hcon,dwPos);
}

int main()
{
	int rep, ren, dato, otro;
	char name [1000][10], email [1000][20], phone [1000][10];
	system ("color 70");
	
	do
	{
		gotoxy(12,2); cout<<"Este programa funciona como una agenda";
		gotoxy(12,3); cout<<"En que renglon quieres poner tus datos?";
		gotoxy(13,4); cin>> ren;
		gotoxy(15,5); cout<<"Escribe un Nombre:";
		gotoxy(16,6); cin>> name [ren];
		gotoxy(15,7); cout<<"Escribe un correo:";
		gotoxy(16,8); cin>> email [ren];
		gotoxy(15,9); cout<<"Escribe un numero:";
		gotoxy(16,10); cin>> phone [ren];
		
	system("cls");
	  do{
		gotoxy(12,1); cout<<"Datos ingresados:";
		gotoxy(13,2); cout<<"1.";
		gotoxy(13,3); cout<<"2.";
		gotoxy(13,4); cout<<"3.";
		gotoxy(13,5); cout<<"4.";
		gotoxy(13,6); cout<<"5.";
		gotoxy(13,7); cout<<"6.";
		gotoxy(13,8); cout<<"7.";
		gotoxy(13,9); cout<<"8.";
		gotoxy(13,10); cout<<"9.";
		gotoxy(13,11); cout<<"10.";
		
	gotoxy(10,14);		cout<<"Quiere consultar alguna anotacion? SI(1) NO(0)";
    gotoxy(59,14);		cin>>dato;
	if (dato==1)
	{
	gotoxy(10,15);cout<<"Ingrese el renglon a consultar:";
	gotoxy(57,15); cin>>ren;
	gotoxy(15,17); cout<<name [ren];
	gotoxy(25,17); cout<<email [ren];
	gotoxy(50,17); cout<<phone [ren];
	
	gotoxy(10,18); cout<<" Volver: (1)";
	 gotoxy(55,18);		cin>>otro;
	 system("cls"); 
	 }
	}while(dato); 
	
	gotoxy(10,18); cout<<":v";
  gotoxy(10,20);		cout<<"Quiere agendar algo mas? SI(1) NO(0)";
    gotoxy(49,20);		cin>>rep;
    system("cls");  
	}while(rep);
	return 0;
}
