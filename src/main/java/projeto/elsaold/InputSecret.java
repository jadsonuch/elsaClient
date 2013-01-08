package projeto.elsaold;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import com.sun.faces.renderkit.html_basic.SecretRenderer;

/****
 * 
 * @author Jadson
 * Custom Renderer para h:inputSecret adicionando o atributo do Html5 placeholder
 *
 */


public class InputSecret extends SecretRenderer {

    @Override
    protected void getEndTextToRender(FacesContext context,
            UIComponent component,
            String currentValue)
     throws java.io.IOException{

        String [] attributes = {"placeholder"};

        ResponseWriter writer = context.getResponseWriter();

        for(String attribute : attributes)
        {
            String value = (String)component.getAttributes().get(attribute);
            if(value != null) {                             
                writer.writeAttribute(attribute, value, attribute);
            }
        }

        super.getEndTextToRender(context, component, currentValue);
        
    }

}
