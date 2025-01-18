// See https://aka.ms/new-console-template for more information
//Console.WriteLine("Hello, World!");

var LadoA = 0d;
var LadoB = 0d;
var resultado = 0d;

Console.WriteLine("Bienvenido");
Console.WriteLine("Ingresa el valor del lado A: ");
LadoA = Convert.ToDouble(Console.ReadLine());

Console.WriteLine("Ingresa el valor del lado B: ");
LadoB = Convert.ToDouble(Console.ReadLine());

//Operador de incremento
LadoA++;
//Operador de decremento
LadoB--;

resultado = LadoA * LadoB;

Console.WriteLine(" El resultado del rectangulo es: " + resultado);
