package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import static org.mockito.Mockito.*;

public class GT4500Test {

  private GT4500 ship;
  private TorpedoStore firstMock = Mockito.mock(TorpedoStore.class);
  private TorpedoStore secondMock = Mockito.mock(TorpedoStore.class);

  @BeforeEach
  public void init(){
    Mockito.mock(TorpedoStore.class);
    this.ship = new GT4500( firstMock, secondMock);
  }

  @Test
  public void fireTorpedo_Single_Success(){
    // Arrange
    Mockito.when(firstMock.fire(1)).thenReturn(true);
    Mockito.when(secondMock.fire(1)).thenReturn(true);
    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    assertEquals(true, result);
    verify(firstMock, times(1)).fire(1);
  }

  @Test
  public void fireTorpedo_All_Success(){
    // Arrange
    Mockito.when(firstMock.fire(1)).thenReturn(true);
    Mockito.when(secondMock.fire(1)).thenReturn(true);
    // Act
    boolean result = ship.fireTorpedo(FiringMode.ALL);

    // Assert
    assertEquals(true, result);
    verify(firstMock, times(1)).fire(1);
  }

}
