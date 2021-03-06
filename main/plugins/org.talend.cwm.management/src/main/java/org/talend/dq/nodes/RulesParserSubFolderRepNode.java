// ============================================================================
//
// Copyright (C) 2006-2016 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.dq.nodes;

import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.repository.model.RepositoryNode;

/**
 * DOC gdbu class global comment. Detailled comment
 */
public class RulesParserSubFolderRepNode extends RulesParserFolderRepNode {

    /**
     * DOC gdbu RulesParserSubFolderRepNode constructor comment.
     * 
     * @param object
     * @param parent
     * @param type
     */
    public RulesParserSubFolderRepNode(IRepositoryViewObject object, RepositoryNode parent, ENodeType type,
            org.talend.core.model.general.Project inWhichProject) {
        super(object, parent, type, inWhichProject);
    }
}
