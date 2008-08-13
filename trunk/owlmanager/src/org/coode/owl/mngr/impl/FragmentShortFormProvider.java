package org.coode.owl.mngr.impl;

import org.coode.owl.mngr.NamedObjectShortFormProvider;
import org.semanticweb.owl.model.OWLEntity;
import org.semanticweb.owl.model.OWLNamedObject;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.util.NamespaceUtil;
import org.semanticweb.owl.util.SimpleShortFormProvider;
/*
* Copyright (C) 2007, University of Manchester
*
* Modifications to the initial code base are copyright of their
* respective authors, or their employers as appropriate.  Authorship
* of the modifications may be determined from the ChangeLog placed at
* the end of this file.
*
* This library is free software; you can redistribute it and/or
* modify it under the terms of the GNU Lesser General Public
* License as published by the Free Software Foundation; either
* version 2.1 of the License, or (at your option) any later version.

* This library is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
* Lesser General Public License for more details.

* You should have received a copy of the GNU Lesser General Public
* License along with this library; if not, write to the Free Software
* Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
*/

/**
 * Author: Nick Drummond<br>
 * http://www.cs.man.ac.uk/~drummond/<br><br>
 * <p/>
 * The University Of Manchester<br>
 * Bio Health Informatics Group<br>
 * Date: Aug 8, 2007<br><br>
 *
 * For OWL Ontologies, gets the prefix created by NamespaceUtil
 * For OWL Entities, delegates to OWLAPI.
 *
 */
public class FragmentShortFormProvider extends SimpleShortFormProvider implements NamedObjectShortFormProvider {

    public String getShortForm(OWLNamedObject obj) {
        String name = "";
        if (obj instanceof OWLOntology){
            name = new NamespaceUtil().generatePrefix(obj.getURI().toString());
        }
        else{
            name = super.getShortForm((OWLEntity)obj);
        }
        return name;
    }
}