public class ConwayLife {

  public static int[][] getGeneration(int[][] cells, int generations) {
    
    
    for(int i=0; i<generations; i++) {
      cells = ConwayLife.evolveGeneration(cells);
    }
    return cells;
    
  }
  
  public static int[][] evolveGeneration(int[][] cells) {
  int[][] newGeneration = new int[cells.length][cells[0].length];
    
    // Iteration through rows
    for(int i=0; i<cells.length; i++) {
      
      // Iteration through cells in a row
      for(int j=0; j<cells[i].length; j++) {
        
        if(cells[i][j] == 0) {
          // Dead cell scenario
          if(ConwayLife.numberOfAliveNeighbourCells(cells, i, j) == 3) {
            newGeneration[i][j] = 1;
          } else {
            newGeneration[i][j] = 0;
          }
        } else {
          // Alive cell scenario
          if(ConwayLife.numberOfAliveNeighbourCells(cells, i, j) == 2 || ConwayLife.numberOfAliveNeighbourCells(cells, i, j) == 3) {
            newGeneration[i][j] = 1;
          } 
          else {
            newGeneration[i][j] = 0;
          }
        }
      }
    }
    return newGeneration;
  }
  
  public static int numberOfAliveNeighbourCells(int[][] cells, int x, int y) {
    int numberAliveNeighbourCells = 0;
    
    if(ConwayLife.isCellAlive(cells, x-1, y-1)) numberAliveNeighbourCells++;
    if(ConwayLife.isCellAlive(cells, x-1, y)) numberAliveNeighbourCells++;
    if(ConwayLife.isCellAlive(cells, x-1, y+1)) numberAliveNeighbourCells++;
    if(ConwayLife.isCellAlive(cells, x, y-1)) numberAliveNeighbourCells++;
    if(ConwayLife.isCellAlive(cells, x, y+1)) numberAliveNeighbourCells++;
    if(ConwayLife.isCellAlive(cells, x+1, y-1)) numberAliveNeighbourCells++;
    if(ConwayLife.isCellAlive(cells, x+1, y)) numberAliveNeighbourCells++;
    if(ConwayLife.isCellAlive(cells, x+1, y+1)) numberAliveNeighbourCells++;
    
    return numberAliveNeighbourCells;
  }
  
  public static boolean isCellAlive(int[][] cells, int x, int y) {
    try {
      if(cells[x][y] == 1)
        return true;
    } catch(Exception e) {
      // The cell is not reachable
    }
    return false;
  }
  
  public static void displayGeneration(int[][] cells) {
    for(int[] row : cells) {
      for(int cell : row) {
        System.out.print(cell + " ");
      }
      System.out.println();
    }
  }
}