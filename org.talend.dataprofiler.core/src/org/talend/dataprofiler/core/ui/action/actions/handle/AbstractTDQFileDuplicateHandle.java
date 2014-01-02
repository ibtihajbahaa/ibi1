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
package org.talend.dataprofiler.core.ui.action.actions.handle;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.talend.commons.exception.BusinessException;
import org.talend.core.model.properties.Item;
import org.talend.dataprofiler.core.exception.ExceptionFactory;
import org.talend.dataprofiler.core.i18n.internal.DefaultMessagesImpl;
import org.talend.dataprofiler.core.ui.utils.WorkbenchUtils;
import org.talend.repository.model.IRepositoryNode;
import org.talend.resource.ResourceManager;

/**
 * This class is used for duplicate TDQFile which only use ByteArray, instead of ModelElement.
 */
public abstract class AbstractTDQFileDuplicateHandle implements IDuplicateHandle {

    protected IFile file;

    AbstractTDQFileDuplicateHandle(IRepositoryNode node) {
        IPath itemPath = WorkbenchUtils.getFilePath(node);
        file = ResourceManager.getRoot().getFile(itemPath);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.dataprofiler.core.ui.action.actions.handle.IDuplicateHandle#duplicate(java.lang.String)
     */
    abstract protected Item createFileItemByDuplicateFile(IFile newFile, String fileExtension, String newName);

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.dataprofiler.core.ui.action.actions.handle.IDuplicateHandle#isExistedLabel(java.lang.String)
     */
    public boolean isExistedLabel(IFile file, String label) {
        IPath fullPath = file.getLocation() == null ? ResourceManager.getRootProject().getLocation().append(file.getFullPath())
                : file.getLocation();
        String fileExtension = fullPath.getFileExtension();
        IPath newPath = fullPath.removeLastSegments(1).append(label).addFileExtension(fileExtension);
        return newPath.toFile().exists();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.talend.dataprofiler.core.ui.action.actions.handle.IDuplicateHandle#duplicateItem(org.talend.core.model.properties
     * .Item, java.lang.String)
     */
    public Item duplicateItem(Item oldItem, String newName) throws BusinessException {
        String fileExtension = file.getFileExtension();

        IPath newFileNamePath = new Path(newName).addFileExtension(fileExtension);
        IFile newFile = file.getParent().getFile(newFileNamePath);

        // createt the file item by the duplicated file
        Item duplicate = createFileItemByDuplicateFile(newFile, fileExtension, newName);
        if (duplicate == null) {
            BusinessException createBusinessException = ExceptionFactory.getInstance().createBusinessException(
                    DefaultMessagesImpl.getString("AbstractTDQFileDuplicateHandle.duplicateFail"));
            throw createBusinessException;
        }
        return duplicate;
    }
}
