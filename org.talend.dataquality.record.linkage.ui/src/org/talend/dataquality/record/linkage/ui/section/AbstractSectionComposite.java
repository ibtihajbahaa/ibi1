// ============================================================================
//
// Copyright (C) 2006-2013 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.dataquality.record.linkage.ui.section;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

/**
 * created by zshen on Aug 20, 2013
 * Detailled comment
 *
 */
public abstract class AbstractSectionComposite {

    protected FormToolkit toolkit;

    protected Section section = null;

    private ScrolledForm form = null;

    public AbstractSectionComposite(final ScrolledForm form, Composite parent, int style, FormToolkit toolkit) {
        this.toolkit = toolkit;
        this.section = this.toolkit.createSection(parent, style);
        this.form = form;
        section.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.VERTICAL_ALIGN_BEGINNING));

        section.addExpansionListener(new ExpansionAdapter() {

            @Override
            public void expansionStateChanged(ExpansionEvent e) {
                form.reflow(true);
            }

        });
        section.setExpanded(true);
    }
    /**
     * Getter for section.
     *
     * @return the section
     */
    public Section getSection() {
        return this.section;
    }

    public void setClient(Control client) {
        this.section.setClient(client);
    }

    /**
     * Getter for form.
     * 
     * @return the form
     */
    public ScrolledForm getForm() {
        return this.form;
    }

}