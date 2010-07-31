/*
* Copyright (C) 2007, University of Manchester
*/
package org.coode.html.doclet;

import org.coode.html.OWLHTMLKit;
import org.coode.html.impl.OWLHTMLConstants;
import org.coode.html.impl.OWLHTMLProperty;
import org.coode.html.url.PermalinkURLScheme;
import org.semanticweb.owlapi.model.OWLObject;

import java.io.PrintWriter;
import java.net.URL;

/**
 * Author: Nick Drummond<br>
 * http://www.cs.man.ac.uk/~drummond/<br><br>
 * <p/>
 * The University Of Manchester<br>
 * Bio Health Informatics Group<br>
 * Date: Feb 7, 2008<br><br>
 */
public abstract class AbstractTitleDoclet<O extends OWLObject> extends AbstractOWLDocDoclet<O> {

    public static final String ID = "doclet.summary.title";

    public AbstractTitleDoclet(OWLHTMLKit kit) {
        super(kit);
    }


    protected void renderHeader(URL pageURL, PrintWriter out) {

        final OWLHTMLKit kit = getOWLHTMLKit();
        final boolean permalink = kit.getHTMLProperties().isSet(OWLHTMLProperty.optionRenderPermalink);

        out.print("<h2>");
        out.print(getTitle());
        out.println("</h2>");

        if (permalink){
            renderLink(OWLHTMLConstants.PERMALINK_LABEL,
                       new PermalinkURLScheme(kit.getURLScheme(), kit).getURLForAbsolutePage(pageURL),
                       null,
                       "permalink",
                       isSingleFrameNavigation(),
                       pageURL,
                       out);
        }

        String subtitle = getSubtitle();
        if (subtitle != null){
            out.print("<h3>");
            out.print(subtitle);
            out.println("</h3>");
        }
    }

    public abstract String getTitle();


    public abstract String getSubtitle();


    protected void renderFooter(URL pageURL, PrintWriter out) {
        // do nothing
    }

    public String getID() {
        return ID;
    }
}