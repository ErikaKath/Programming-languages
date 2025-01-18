using System;
using System.IO;

class Program
{
    static void Main()
    {
        int[] numeros = new int[10];

        try
        {
          
            // Solicitar al usuario 10 números diferentes
            Console.WriteLine("Ingrese 10 números diferentes:");

            for (int i = 0; i < 10; i++)
            {
                Console.Write($"Número {i + 1}: ");
                numeros[i] = Convert.ToInt32(Console.ReadLine());
            }

            // Crear una carpeta "Resultados" si no existe

            string carpetaResultados = "Resultados";

            if (!Directory.Exists(carpetaResultados))
            {
               Directory.CreateDirectory(carpetaResultados);
            }
           
            // Guardar los números ordenados utilizando los métodos de ordenamiento

            Burbuja(numeros);
            GuardarEnArchivo(Path.Combine(carpetaResultados, "Burbuja.txt"), numeros);

            //Array.Clear(numeros, 0, numeros.Length); // Limpiar el array para el próximo método


            Shell(numeros);
            GuardarEnArchivo(Path.Combine(carpetaResultados, "Shell.txt"), numeros);

            //Array.Clear(numeros, 0, numeros.Length); // Limpiar el array para el próximo método

            Seleccion(numeros);
            GuardarEnArchivo(Path.Combine(carpetaResultados, "Seleccion.txt"), numeros);

            //Array.Clear(numeros, 0, numeros.Length); // Limpiar el array para el próximo método

            Insercion(numeros);
            GuardarEnArchivo(Path.Combine(carpetaResultados, "Insercion.txt"), numeros);

            Console.WriteLine("Los números ordenados han sido guardados en archivos.");
        }
        catch (Exception ex) 
        {
            Console.WriteLine($"Error: {ex.Message}");
        }
    }

    static void Burbuja(int[] arr)
    {
        // Implementación del método de ordenamiento Burbuja
        int n = arr.Length;

        for (int i = 0; i < n - 1; i++)
        {
            for (int j = 0; j < n - i - 1; j++)
            {
                if (arr[j] > arr[j + 1])
                {
                    // Intercambiar elementos si están en el orden incorrecto
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    static void Shell(int[] arr)
    {
        // Implementación del método de ordenamiento Shell
        int n = arr.Length;

        for (int gap = n / 2; gap > 0; gap /= 2)
        {
            for (int i = gap; i < n; i += 1)
            {
                int temp = arr[i];

                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                {
                    arr[j] = arr[j - gap];
                }

                arr[j] = temp;
            }
        }
    }

    static void Seleccion(int[] arr)
    {
        // Implementación del método de ordenamiento por Selección
        int n = arr.Length;

        for (int i = 0; i < n - 1; i++)
        {
            int minIndex = i;
            for (int j = i + 1; j < n; j++)
            {
                if (arr[j] < arr[minIndex])
                {
                    minIndex = j;
                }
            }

            // Intercambiar el elemento mínimo con el primer elemento no ordenado
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    static void Insercion(int[] arr)
    {
        // Implementación del método de ordenamiento por Inserción
        int n = arr.Length;

        for (int i = 1; i < n; i++)
        {
            int key = arr[i];
            int j = i - 1;

            // Mover los elementos mayores que key a una posición adelante de su posición actual
            while (j >= 0 && arr[j] > key)
            {
                arr[j + 1] = arr[j];
                j = j - 1;
            }

            arr[j + 1] = key;
        }
    }

    static void GuardarEnArchivo(string nombreArchivo, int[] arr)
    {
        // Guardar los números ordenados en un archivo
        using (StreamWriter sw = new StreamWriter(nombreArchivo))
        {
            foreach (var numero in arr)
            {
                sw.WriteLine(numero);
            }
        }
    }
}
