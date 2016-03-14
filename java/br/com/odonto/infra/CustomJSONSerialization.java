/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.odonto.infra;

import br.com.caelum.vraptor.interceptor.TypeNameExtractor;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.serialization.ProxyInitializer;
import br.com.caelum.vraptor.serialization.xstream.XStreamBuilder;
import br.com.caelum.vraptor.serialization.xstream.XStreamJSONSerialization;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.SingleValueConverter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletResponse;

@Component
public class CustomJSONSerialization extends XStreamJSONSerialization {

    public CustomJSONSerialization(HttpServletResponse response, TypeNameExtractor extractor, ProxyInitializer initializer, XStreamBuilder builder) {
        super(response, extractor, initializer, builder);
    }

    @Override
    public XStream getXStream() {
        @SuppressWarnings("deprecation")
        XStream xstream = super.getXStream();
        xstream.aliasSystemAttribute(null, "class");  
        xstream.registerConverter(new SingleValueConverter() {
            @Override
            public boolean canConvert(Class arg0) {
                return Date.class.isAssignableFrom(arg0);
            }

            @Override
            public String toString(Object date) {
                return new SimpleDateFormat("dd/MM/yyyy").format(date);
            }

            @Override
            public Object fromString(String arg0) {
                return null;
            }
        });
        return xstream;
    }
}
