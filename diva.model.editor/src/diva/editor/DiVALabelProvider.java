/**
 * Copyright 2014 SINTEF <brice.morin@sintef.no>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package diva.editor;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.IFontProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableColorProvider;
import org.eclipse.jface.viewers.ITableFontProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;

import diva.visitors.Visitable;

public class DiVALabelProvider extends ColumnLabelProvider implements ILabelProvider, ITableLabelProvider, INotifyChangedListener, IColorProvider, ITableColorProvider, IFontProvider, ITableFontProvider {

	protected AdapterFactoryLabelProvider adapterFactoryLabelProvider = null;
	
	public DiVALabelProvider(AdapterFactoryLabelProvider adapterFactoryLabelProvider) {
		this.adapterFactoryLabelProvider = adapterFactoryLabelProvider;
	}
	

	
	public Font getFont(Object element) {
		return getFont(element, 0);
	}

	
	public Color getBackground(Object element) {
		return getBackground(element, 0);
	}

	
	public Color getForeground(Object element) {
		return getForeground(element, 0);
	}

	
	public Font getFont(Object element, int columnIndex) {
		return null;
	}

	
	public Color getBackground(Object element, int columnIndex) {
		if (element instanceof Visitable)
			return ((Visitable)element).accept(DiVABackgroundProvider.getInstance(), null);
		else
			return null;
	}

	
	public Color getForeground(Object element, int columnIndex) {
		return null;
	}

	
	public Image getImage(Object element) {
		return adapterFactoryLabelProvider.getImage(element);
	}

	
	public String getText(Object element) {
		if (element instanceof Visitable) {
			try {
				return ((Visitable)element).accept(DiVATextProvider.getInstance(), null);
			}
			catch(Exception e) {
				// null pointer might occur if the mandatory properties of the object
				// are not populated. In this case use the default label.
				return adapterFactoryLabelProvider.getText(element);
			}
		}
		return adapterFactoryLabelProvider.getText(element);
	}

	
	public void notifyChanged(Notification notification) {
		adapterFactoryLabelProvider.notifyChanged(notification);
		
	}

	
	public Image getColumnImage(Object element, int columnIndex) {
		return adapterFactoryLabelProvider.getColumnImage(element, columnIndex);
	}

	
	public String getColumnText(Object element, int columnIndex) {
		return adapterFactoryLabelProvider.getColumnText(element, columnIndex);
	}

	
	public void addListener(ILabelProviderListener listener) {
		adapterFactoryLabelProvider.addListener(listener);
		
	}

	
	public void dispose() {
		adapterFactoryLabelProvider.dispose();
	}

	
	public boolean isLabelProperty(Object element, String property) {
		return adapterFactoryLabelProvider.isLabelProperty(element, property);
	}

	
	public void removeListener(ILabelProviderListener listener) {
		adapterFactoryLabelProvider.removeListener(listener);
	}

	

}
