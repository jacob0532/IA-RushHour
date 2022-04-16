

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
            System.out.println("");
        }
    }
    
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
        System.out.println("Matriz:");
        printMatriz(b.getConfiguration());
        System.out.println("h= "+b.getH());
        System.out.println("");
        if( b.getH()>1){
            int minorF=0; 
            for (int x = 1; x < open.size(); x++) {
                if(open.get(x).getF()<open.get(minorF).getF()){
                    minorF = x;
                }
            }
            return calcAStar(open.get(minorF));
        }else{
            System.out.println("llego al final jaja "+closed.size());
            return b;
        }
    }
    
    public int calcH(int[][] config, int[] meta){
        int h=0;
        for (int x = 0; x < config.length; x++) {
            for (int y = 0; y < config[x].length; y++) {
              if(config[x][y]==1){
                  h+=meta[0]-x;
                  h+=meta[1]-y;
              }
            }
        }
        if(h<0){
        h=h*-1;
        }
        return h;
    }
    
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
         //         System.out.println("id diferente de 0= "+id);
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
                          //System.out.println("Vehiculo con id= "+id+" anadido");
                          ids.add(id);
                          possibleStates.addAll( move(actual,vertical,x,y));
                      }
                  }else{System.out.println("Vehiculo con numeroo incorrecto de cuadros = " +count  +", id= "+id);}
              }
            }
        }
        
        return possibleStates;
    }
    
    public boolean contain(ArrayList<int [][] > list, int[][] obj){
        for (int i = 0; i < list.size(); i++) {
            if(Arrays.deepEquals(list.get(i),obj)){return true;}
        }
        return false;
    }
    
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
