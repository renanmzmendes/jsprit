/*******************************************************************************
 * Copyright (C) 2013  Stefan Schroeder
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Contributors:
 *     Stefan Schroeder - initial API and implementation
 ******************************************************************************/
package basics;

public final class Pickup extends Service {

	public static class Builder extends Service.Builder {

		public static Builder newInstance(String id, int size){
			return new Builder(id,size);
		}
		
		Builder(String id, int size) {
			super(id, size);
		}
		
		public Pickup build(){
			if(locationId == null) { 
				if(coord == null) throw new IllegalStateException("either locationId or a coordinate must be given. But is not.");
				locationId = coord.toString();
			}
			this.setType("pickup");
			return new Pickup(this);
		}
		
	}
	
	Pickup(Builder builder) {
		super(builder);
	}
	
}