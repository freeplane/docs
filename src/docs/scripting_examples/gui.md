# GUI
Using simple GUI to display information on the screen, integrated into freeplane.

### Simple YES/NO Question

```groovy
import org.freeplane.core.ui.components.UITools;
def result = UITools.showConfirmDialog(node.delegate, "Simple Yes/No Question", "window title",0)
c.statusInfo=result
```

### Simple Msgbox
```groovy
import org.freeplane.core.ui.components.UITools;
UITools.informationMessage('Simple Messagebox')

```
