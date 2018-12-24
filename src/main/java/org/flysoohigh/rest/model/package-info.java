@XmlJavaTypeAdapters({
        @XmlJavaTypeAdapter(type=LocalDateTime.class,
                value=LocalDateTimeXMLAdapter.class),
})

/**
 * Created on 24.12.2018.
 */
package org.flysoohigh.rest.model;

import org.flysoohigh.rest.adapters.LocalDateTimeXMLAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;
import java.time.LocalDateTime;