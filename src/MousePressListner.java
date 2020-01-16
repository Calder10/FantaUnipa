import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/** Interfaccia funzionale, contenente dei metodi per la gestione degli eventi del mouse
 * @author Salvatore Calderaro
 *@author Gaspare Casano
 */
@FunctionalInterface
public interface MousePressListner extends MouseListener{
  @Override
  default public void mouseEntered(final MouseEvent e) {
  }

  @Override
  default public void mouseExited(final MouseEvent e) {
  }

  @Override
  default public void mousePressed(final MouseEvent e) {
  }

  @Override
  default public void mouseReleased(final MouseEvent e) {
  }
}