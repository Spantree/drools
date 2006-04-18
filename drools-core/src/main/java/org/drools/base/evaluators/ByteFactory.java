package org.drools.base.evaluators;
/*
 * Copyright 2005 JBoss Inc
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */



import org.drools.base.BaseEvaluator;
import org.drools.spi.Evaluator;

public class ByteFactory {

    public static Evaluator getByteEvaluator(int operator) {
        switch ( operator ) {
            case Evaluator.EQUAL :
                return ByteEqualEvaluator.INSTANCE;
            case Evaluator.NOT_EQUAL :
                return ByteNotEqualEvaluator.INSTANCE;
            case Evaluator.LESS :
                return ByteLessEvaluator.INSTANCE;
            case Evaluator.LESS_OR_EQUAL :
                return ByteLessOrEqualEvaluator.INSTANCE;
            case Evaluator.GREATER :
                return ByteGreaterEvaluator.INSTANCE;
            case Evaluator.GREATER_OR_EQUAL :
                return ByteGreaterOrEqualEvaluator.INSTANCE;
            default :
                throw new RuntimeException( "Operator '" + operator + "' does not exist for ByteEvaluator" );
        }
    }

    static class ByteEqualEvaluator extends BaseEvaluator {
        public final static Evaluator INSTANCE = new ByteEqualEvaluator();

        private ByteEqualEvaluator() {
            super( Evaluator.BYTE_TYPE,
                   Evaluator.EQUAL );
        }

        public boolean evaluate(Object object1,
                                Object object2) {
            if ( object1 == null ) return object2 == null;
            return ((Byte) object1).equals( object2 );
        }

        public String toString() {
            return "Byte ==";
        }
    }

    static class ByteNotEqualEvaluator extends BaseEvaluator {
        public final static Evaluator INSTANCE = new ByteNotEqualEvaluator();

        private ByteNotEqualEvaluator() {
            super( Evaluator.BYTE_TYPE,
                   Evaluator.NOT_EQUAL );
        }

        public boolean evaluate(Object object1,
                                Object object2) {
            if ( object1 == null ) return object2 != null;
            return !((Byte) object1).equals( object2 );
        }

        public String toString() {
            return "Byte !=";
        }
    }

    static class ByteLessEvaluator extends BaseEvaluator {
        public final static Evaluator INSTANCE = new ByteLessEvaluator();

        private ByteLessEvaluator() {
            super( Evaluator.BYTE_TYPE,
                   Evaluator.LESS );
        }

        public boolean evaluate(Object object1,
                                Object object2) {
            return ((Byte) object1).byteValue() < ((Byte) object2).byteValue();
        }

        public String toString() {
            return "Byte <";
        }
    }

    static class ByteLessOrEqualEvaluator extends BaseEvaluator {
        public final static Evaluator INSTANCE = new ByteLessOrEqualEvaluator();

        private ByteLessOrEqualEvaluator() {
            super( Evaluator.BYTE_TYPE,
                   Evaluator.LESS_OR_EQUAL );
        }

        public boolean evaluate(Object object1,
                                Object object2) {
            return ((Byte) object1).byteValue() <= ((Byte) object2).byteValue();
        }

        public String toString() {
            return "Byte <=";
        }
    }

    static class ByteGreaterEvaluator extends BaseEvaluator {
        public final static Evaluator INSTANCE = new ByteGreaterEvaluator();

        private ByteGreaterEvaluator() {
            super( Evaluator.BYTE_TYPE,
                   Evaluator.GREATER );
        }

        public boolean evaluate(Object object1,
                                Object object2) {
            return ((Byte) object1).byteValue() > ((Byte) object2).byteValue();
        }

        public String toString() {
            return "Byte >";
        }
    }

    static class ByteGreaterOrEqualEvaluator extends BaseEvaluator {
        private final static Evaluator INSTANCE = new ByteGreaterOrEqualEvaluator();

        private ByteGreaterOrEqualEvaluator() {
            super( Evaluator.BYTE_TYPE,
                   Evaluator.GREATER_OR_EQUAL );
        }

        public boolean evaluate(Object object1,
                                Object object2) {
            return ((Byte) object1).byteValue() >= ((Byte) object2).byteValue();
        }

        public String toString() {
            return "Byte >=";
        }
    }

}