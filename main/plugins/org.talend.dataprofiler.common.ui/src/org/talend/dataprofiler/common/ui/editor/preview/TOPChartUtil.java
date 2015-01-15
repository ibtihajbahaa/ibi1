// ============================================================================
//
// Copyright (C) 2006-2014 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.dataprofiler.common.ui.editor.preview;

import java.util.List;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.talend.dataprofiler.service.ITOPChartService;
import org.talend.dq.helper.AbstractOSGIServiceUtils;

/**
 * created by yyin on 2014-12-15 Detailled comment
 * 
 */
public class TOPChartUtil extends AbstractOSGIServiceUtils {

    public static final String PLUGIN_NAME = "org.talend.dataprofiler.top.chart"; //$NON-NLS-1$

    private static final String CHART_VERSION = "_6.0.0"; //$NON-NLS-1$

    public static final String JAR_FILE_NAME = PLUGIN_NAME + CHART_VERSION + ".jar"; //$NON-NLS-1$ 

    private static TOPChartUtil instance;

    private ITOPChartService chartService;

    public static TOPChartUtil getInstance() {
        if (instance == null) {
            instance = new TOPChartUtil();
        }
        return instance;
    }

    @Override
    public boolean isServiceInstalled() {
        initService(true);
        return this.chartService != null;
    }

    @Override
    public String getPluginName() {
        return ITOPChartService.PLUGIN_NAME;
    }

    @Override
    public String getJarFileName() {
        return ITOPChartService.JAR_FILE_NAME;
    }

    @Override
    public String getServiceName() {
        return ITOPChartService.class.getName();
    }

    @Override
    protected String getMissingMessageName() {
        return "TOPChartUtil.missingTopChart"; //$NON-NLS-1$
    }

    @Override
    protected String getRestartMessageName() {
        return "TOPChartUtil.restartToLoadTopChart"; //$NON-NLS-1$
    }

    @Override
    protected void setService(BundleContext context, ServiceReference serviceReference) {
        if (serviceReference != null) {
            Object obj = context.getService(serviceReference);
            if (obj != null) {
                this.chartService = (ITOPChartService) obj;
            }
        }
    }

    public Object createDefaultCategoryDataset() {
        if (isServiceInstalled()) {
            return chartService.createDefaultCategoryDataset();
        }
        return null;
    }

    public void addValueToCategoryDataset(Object dataset, double value, String labelX, String labelY) {
        if (isServiceInstalled()) {
            chartService.addValueToCategoryDataset(dataset, value, labelX, labelY);
        }
    }

    public int getRowCount(Object dataset) {
        if (isServiceInstalled()) {
            return chartService.getRowCount(dataset);
        }
        return Integer.MIN_VALUE;
    }

    public int getColumnCount(Object dataset) {
        if (isServiceInstalled()) {
            return chartService.getColumnCount(dataset);
        }
        return Integer.MIN_VALUE;
    }

    public Number getValue(Object dataset, int row, int column) {
        if (isServiceInstalled()) {
            return chartService.getValue(dataset, row, column);
        }
        return Integer.MIN_VALUE;
    }

    public Comparable getRowKey(Object dataset, int row) {
        if (isServiceInstalled()) {
            return chartService.getRowKey(dataset, row);
        }
        return Integer.MIN_VALUE;
    }

    public int getRowIndex(Object dataset, Comparable key) {
        if (isServiceInstalled()) {
            return chartService.getRowIndex(dataset, key);
        }
        return Integer.MIN_VALUE;
    }

    public List getRowKeys(Object dataset) {
        if (isServiceInstalled()) {
            return chartService.getRowKeys(dataset);
        }
        return null;
    }

    public Comparable getColumnKey(Object dataset, int column) {
        if (isServiceInstalled()) {
            return chartService.getColumnKey(dataset, column);
        }
        return Integer.MIN_VALUE;
    }

    public int getColumnIndex(Object dataset, Comparable key) {
        if (isServiceInstalled()) {
            return chartService.getColumnIndex(dataset, key);
        }
        return Integer.MIN_VALUE;
    }

    public List getColumnKeys(Object dataset) {
        if (isServiceInstalled()) {
            return chartService.getColumnKeys(dataset);
        }
        return null;
    }

    public Number getValue(Object dataset, Comparable rowKey, Comparable columnKey) {
        if (chartService != null) {
            return chartService.getValue(dataset, rowKey, columnKey);
        }
        return Integer.MIN_VALUE;
    }

    public void clearDataset(Object dataset) {
        if (chartService != null) {
            chartService.clearDataset(dataset);
        }
    }

}