

package AEstrella;
import java.lang.reflect.Array;
import java.util.ArrayList; 
import java.util.Arrays;
/**
 *
    * @author Alexander
 */
public class Heuristic {
    ArrayList<Board> open  =  new ArrayList<>();
    ArrayList<Board> closed =  new ArrayList<>();
    
    public void printMatriz(int[][] m ){
        for (int x = 0; x < m.length; x++) {
            for (int y = 0; y < m[x].length; y++) {
                System.out.print(m[x][y]+", ");
            }
            
        }
    }
    
    /*
        Parameters: Objeto de tipo Board que representa un del tablero 
        Return: Objeto de tipo Board que representa la solución
        Details: Como funciona el algoritmo de A* (estrella), maneja por medio de dos listas de objetos
            de tipo Board(Lista de abiertas, lista de cerrados), la función es una función recursica que recibe 
            un posible estado, lo añade a los casos cerrados,genera las posibles conbinaciones siguientes, si alguna
            de las nuevas ya existe en alguna lista, solo la ignora y caso contrario se añade a la lista de abiertos, en general
            recorre por medio de un tipo de arbol n´ario todas las posibilidades hasta encontrar la solución optima, la cual 
            corresponde al objeto de tipo board con f más pequeño
    */
    public Board calcAStar(Board b){
        closed.add(b);
        open.remove(b);
        
        b.setH( calcH(b.getConfiguration(), b.getExit()));
        ArrayList<int[][]> states = generateStates(b);
        for (int x = 0; x < states.size(); x++) {
            boolean ready = false;
            for (int y = 0; y < open.size(); y++) {
                if (Arrays.deepEquals(open.get(y).getConfiguration(),states.get(x))){
                    if(open.get(y).getG()> b.getG()+1){
                        open.get(y).setPadre(b);
                        open.get(y).setG(b.getG());
                    }
                    ready = true;
                }
            }
            for (int y = 0; y < closed.size(); y++) {
                if (Arrays.deepEquals(closed.get(y).getConfiguration(),states.get(x))){
                    ready = true;
                }
            }
            if(!ready){
                Board aux =new Board(states.get(x),b.getExit());
                aux.setPadre(b);
                aux.setG(b.getG()+1);
                aux.setH(calcH(aux.getConfiguration(), aux.getExit()));

                
                open.add(aux);
                
            }
        }
        
       //Se imprimer la matriz para ver como va
        // printMatriz(b.getConfiguration());
        if( b.getH()>1){
            int minorF=0; 
            for (int x = 1; x < open.size(); x++) {
                if(open.get(x).getF()<open.get(minorF).getF()){
                    minorF = x;
                }
            }
            return calcAStar(open.get(minorF));
        }else{
            return b;
        }
    }
 
    /*
    Parameters: La matriz de la configuración actual del tablero y una arreglo 
        con la x y x correspondientes a la posición de la meta.
    Return: Retorna un entero con una estimación de H techo
    Details: Realiza una comparación entre lasposiciones asociadas al carrito principal
        Y el punto asociado a la meta, retorna el valor que da esa comparación con resta.
    */    
    public int calcH(int[][] config, int[] meta){
        int h=0;
        int var=0;
        for (int x = 0; x < config.length; x++) {
            for (int y = 0; y < config[x].length; y++) {
              if(config[x][y]==1){
                  var=(meta[0]-x)+(meta[1]-y);
                  if(var<0){
                      var = var*-1;
                  }
                  if(h==0){
                      h = var;
                  }
                  else{
                      if(var>h){
                          h = var;
                      }
                  }
              }
            }
        }
        /*if(h<0){
        h=h*-1;
        }*/
        return h;
    }
    
    /*
        Parameters: Una matriz de enteros que representa una configuración 
            posible para el estado
        Return: Una copia de la matriz de configuración ingresada.
        Details: Recorre la matriz recibida por parametro y genera un copia para que 
            no haya corrupción de datos por manejo de punteros
                
    */
    public int[][] copyMatriz(int[][] actual){
        int [][] copyActual ={
                        {0,0,0,0,0,0},
                        {0,0,0,0,0,0},
                        {0,0,0,0,0,0},
                        {0,0,0,0,0,0},
                        {0,0,0,0,0,0},
                        {0,0,0,0,0,0}
                                        };
        
        for (int x = 0; x < actual.length; x++) {
            for (int y = 0; y < actual[x].length; y++) {
                copyActual[x][y] = actual[x][y];
            }
        }
        return copyActual;
    }
    
    /*
        Parameters: Objeto de tipo Board
        Return: Lista de matrices de enteros, que refieren a las posibles combinaciones
            a armar a partir de ese estado.
        Details: recorre la matriz de configuración asignada al objeto Board ingresado por parametro, 
            esto lo hace con el fin de identificar cada carrito, verificar si es vertical u horizontal 
            y si tiene la posibilidad de moverse, en caso de tener la posibilidad de moverse, añade a la
            lista que se va a retornar el retorno de la función realizada para mover un carrito.
    
    */
    public ArrayList<int[][]> generateStates(Board pBoard)
    {
        ArrayList<Integer> ids = new ArrayList<>();
        ArrayList<int[][]> possibleStates= new ArrayList<>();
        int[][]  actual = copyMatriz( pBoard.getConfiguration());
        for (int x = 0; x < actual.length; x++) {
            for (int y = 0; y < actual[x].length; y++) {
              actual = copyMatriz( pBoard.getConfiguration());
              if(actual[x][y]!=0)
              {
                 
                   
                  int id =actual[x][y];
                  boolean vertical = false;
                  int count=1;
                  int aux = x;
                  //revisar arriba
                  
                  while(aux>0)
                  {
                      if(actual[aux-1][y]==id){
                          vertical = true;
                          count++;
                      }
                      aux--;
                  }
                  aux = x;
                  //revisar abajo
                  while(aux<5)
                  {
                      if(actual[aux+1][y]==id){
                          vertical = true;
                          count++;
                      }
                      aux++;
                  }
                  aux =y;
                  //revisar izquierda
                  while(aux>0)
                  {
                      if(actual[x][aux-1]==id){
                          if(vertical){System.out.println("Error: vehiculo en dos direciones");}
                          count++;
                      }
                      aux--;
                  }
                  aux = y;
                  //revisar derecha
                  while(aux<5)
                  {
                      if(actual[x][aux+1]==id){
                          if(vertical){System.out.println("Error: vehiculo en dos direciones");}
                          count++;
                      }
                      aux++;
                  }
                  if (count<=3 && count>=2 ){
                      
                      if(!ids.contains(id)){
                          ids.add(id);
                          possibleStates.addAll( move(actual,vertical,x,y));
                      }
                  }else{System.out.println("Vehiculo con numeroo incorrecto de cuadros = " +count  +", id= "+id);}
              }
            }
        }
        
        return possibleStates;
    }
    
    /*
        Parameters: Una lista de matrices de dos dimenciones, una matriz de dos dimenciones 
        Return: Un booleando que indica si la lista ingresada por parametro ya contiene una matriz igual
            a la ingresada por parametro
        Details: Recorre la lista comparando matrices con la pasada por parametro, 
            en caso de encontrar una coincidencia retorna true.
        //Justificación: Parece basico, pero en java el metodo contain de las listas compara espacios de memoria en el caso de 
          los matrices, por esto fue necesario realizar esta función
    */
    public boolean contain(ArrayList<int [][] > list, int[][] obj){
        for (int i = 0; i < list.size(); i++) {
            if(Arrays.deepEquals(list.get(i),obj)){return true;}
        }
        return false;
    }
    
    /*
        Parameters: Matriz de enteros que se refiere a una configuración del tablero, 
                    un booleano que se refiere a si el carrito a mover es vertical o no
                    dos enteros x, y que se refieren a la posición de un cuadro del carrito a mover
        Return: Una lista con las posibles configuraciones 
        Details: Mueve el auto con el id correspondiente a los indices x, y recibidos, comprueba los posbiles mocimientos 
            Y los añade a la lista a retornar.
    */
    public ArrayList<int[][]> move(int [][] actual, boolean isVertical,int x, int y ){
        int [][] actualCopy = copyMatriz(actual);
        int id= actualCopy[x][y];
        ArrayList<int [][] > possibleStates = new ArrayList<>();
        int index=0;
        
        if (isVertical){
            //mover arriba
            index=0;
            while(index < 5){
               if(actualCopy[index+1][y]==id && actualCopy[index][y]==0 )
               {
                   actualCopy[index][y]=id;
                   while(index < 5){
                       if(actualCopy[index+1][y]!=id){
                           actualCopy[index][y]=0;
                           break;
                       }
                       if(index+1==5){
                           actualCopy[index+1][y]=0;
                           break;
                       }
                       index++;
                   }
                   break;
               }
               index++;
            }
            //add to posible States
            if (!contain(possibleStates,actualCopy)&& !Arrays.deepEquals(actualCopy,actual) ){
                possibleStates.add(actualCopy);
                //printMatriz(actualCopy);
            }
            //mover abajo
            //reset actual state
            actualCopy = copyMatriz(actual);
            index=5;
            while(index >0){
               if(actualCopy[index-1][y]==id && actualCopy[index][y]==0 )
               {
                   actualCopy[index][y]=id;
                   while(index > 0){
                       if(actualCopy[index-1][y]!=id){
                           actualCopy[index][y]=0;
                           break;
                       }
                       if(index-1==0){
                           actualCopy[index-1][y]=0;
                           break;
                       }
                       index--;
                   }
                   break;
               }
               index--;
            }
            //add to posible States
            if (!contain(possibleStates,actualCopy)&& !Arrays.deepEquals(actualCopy,actual) ){
                possibleStates.add(actualCopy);
                //printMatriz(actualCopy);
            }
        }else{
            //mmover derecha
            
            index=0;
            while(index <5){
               if(actualCopy[x][index+1]==id && actualCopy[x][index]==0 )
               {
                   actualCopy[x][index]=id;
                   while(index < 5){
                       if(actualCopy[x][index+1]!=id){
                           actualCopy[x][index]=0;
                           break;
                       }
                       if(index+1==5){
                           actualCopy[x][index+1]=0;
                           break;
                       }
                       index++;
                   }
                   break;
               }
               index++;
            }
            //add to posible States
            if (!contain(possibleStates,actualCopy)&& !Arrays.deepEquals(actualCopy,actual) ){
                possibleStates.add(actualCopy);
               // printMatriz(actualCopy);
            }
            //mmover izquierda
            //reset actual state
            actualCopy = copyMatriz(actual);
            
            index=5;
            while(index >0){
               if(actualCopy[x][index-1]==id && actualCopy[x][index]==0 )
               {
                   actualCopy[x][index]=id;
                   while(index > 0){
                       if(actualCopy[x][index-1]!=id){
                           actualCopy[x][index]=0;
                           break;
                       }
                       if(index-1==0){
                           actualCopy[x][index-1]=0;
                           break;
                       }
                       index--;
                   }
                   break;
               }
               index--;
            }
            //add to posible States
            if (!contain(possibleStates,actualCopy)&& !Arrays.deepEquals(actualCopy,actual) ){
                possibleStates.add(actualCopy);
                //printMatriz(actualCopy);
            }
        }
        return possibleStates;
    }
}
