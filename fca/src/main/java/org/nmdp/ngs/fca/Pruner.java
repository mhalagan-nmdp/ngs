/*

    ngs-fca  Formal concept analysis for genomics.
    Copyright (c) 2014-2015 National Marrow Donor Program (NMDP)

    This library is free software; you can redistribute it and/or modify it
    under the terms of the GNU Lesser General Public License as published
    by the Free Software Foundation; either version 3 of the License, or (at
    your option) any later version.

    This library is distributed in the hope that it will be useful, but WITHOUT
    ANY WARRANTY; with out even the implied warranty of MERCHANTABILITY or
    FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public
    License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with this library;  if not, write to the Free Software Foundation,
    Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307  USA.

    > http://www.gnu.org/licenses/lgpl.html

*/

package org.nmdp.ngs.fca;

import java.util.List;
import java.util.ArrayList;

public class Pruner<L, W> {
	protected Vertex parent;
	protected List<L> labels;
	protected List<W> weights;
	
	public Pruner()
	{
		labels = new ArrayList<L>();
		weights = new ArrayList<W>();
	}
	
	public void setLabels(final ArrayList<L> labels)
	{
		this.labels = labels;
	}
	
	public void setWeights(final ArrayList<W> weights)
	{
		this.weights = weights;
	}
	
	public boolean pruneVertex(Vertex vertex)
	{
		parent = vertex;
		
		if(labels.contains(vertex.getLabel()))
		{
			return true;
		}
		
		return false;
	}
	
	public boolean pruneEdge(Vertex.Edge edge)
	{
		if(weights.contains(edge.weight()))
		{
			return true;
		}
		return false;
	}
}