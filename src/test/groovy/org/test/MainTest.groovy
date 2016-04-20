package org.test

import spock.lang.Specification

class MainTest extends Specification{

    def stack = new Stack()

    def "size"() {
        expect: stack.size() == 0
    }

}
