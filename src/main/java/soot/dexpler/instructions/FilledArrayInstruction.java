package soot.dexpler.instructions;

/*-
 * #%L
 * Soot - a J*va Optimization Framework
 * %%
 * Copyright (C) 2012 Michael Markert, Frank Hartmann
 *
 * (c) 2012 University of Luxembourg - Interdisciplinary Centre for
 * Security Reliability and Trust (SnT) - All rights reserved
 * Alexandre Bartel
 *
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 2.1 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-2.1.html>.
 * #L%
 */

import java.util.HashSet;
import java.util.Set;

import org.jf.dexlib2.iface.instruction.Instruction;
import org.jf.dexlib2.iface.instruction.ReferenceInstruction;
import org.jf.dexlib2.iface.reference.TypeReference;

import soot.Type;
import soot.dexpler.DexBody;
import soot.dexpler.DexType;

public abstract class FilledArrayInstruction extends DexlibAbstractInstruction implements DanglingInstruction {

  public FilledArrayInstruction(Instruction instruction, int codeAddress) {
    super(instruction, codeAddress);
  }

  public void finalize(DexBody body, DexlibAbstractInstruction successor) {
    // // defer final jimplification to move result
    // if (successor instanceof MoveResultInstruction) {
    // MoveResultInstruction i = (MoveResultInstruction)successor;
    // i.setLocalToMove(arrayLocal);
    // if (lineNumber != -1)
    // i.setTag(new SourceLineNumberTag(lineNumber));
    // }
  }

  @Override
  public Set<Type> introducedTypes() {
    ReferenceInstruction i = (ReferenceInstruction) instruction;

    Set<Type> types = new HashSet<Type>();
    types.add(DexType.toSoot((TypeReference) i.getReference()));
    return types;
  }

}
