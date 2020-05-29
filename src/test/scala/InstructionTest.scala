import org.scalatest.FunSuite

class InstructionTest extends FunSuite {
  var add: Add = new Add
  var mul: Mul = new Mul
  var swap: Swap = new Swap

  test("Add registerA=2 with registerB=3, should give registerA=5") {
    var microprocessor: Microprocessor = new Microprocessor
    microprocessor.registerA = 3
    microprocessor.registerB = 2

    microprocessor.acceptOperation(add)
    assert(microprocessor.registerA === 5)
  }

  test("Mul registerA=2 with registerB=3, should give registerA=6") {
    var microprocessor: Microprocessor = new Microprocessor
    microprocessor.registerA = 3
    microprocessor.registerB = 2

    microprocessor.acceptOperation(mul)
    assert(microprocessor.registerA === 6)
  }

  test("swap registerA=2 with registerB=3, should give registerA=3, registerB=2") {
    var microprocessor: Microprocessor = new Microprocessor
    microprocessor.registerA = 3
    microprocessor.registerB = 2

    microprocessor.acceptOperation(swap)
    assert(microprocessor.registerA === 2 && microprocessor.registerB === 3)
  }

  test("load address 3, should give registerA=0") {
    var microprocessor: Microprocessor = new Microprocessor
    microprocessor.registerA = 3
    microprocessor.registerB = 2
    var load: Load = new Load(54)

    microprocessor.acceptOperation(load)
    assert(microprocessor.registerA === 0)
  }

  test("store address 0 , should give memory(0)=0") {
    var microprocessor: Microprocessor = new Microprocessor
    microprocessor.registerA = 3
    microprocessor.registerB = 2
    var store: Store = new Store(0)

    microprocessor.acceptOperation(store)
    assert(microprocessor.memory(0) === 3)
  }

  test("If instruction, should give registerA=6") {
    var microprocessor: Microprocessor = new Microprocessor
    microprocessor.registerA = 0
    microprocessor.registerB = 2
    var anIf: If = new If(new Program(List(add, mul, add)))

    microprocessor.acceptOperation(anIf)
    assert(microprocessor.registerA === 6)
  }

  test("If instruction with registerA not 0, should give registerA=1, no effect") {
    var microprocessor: Microprocessor = new Microprocessor
    microprocessor.registerA = 1
    microprocessor.registerB = 2
    var anIf: If = new If(new Program(List(add, mul)))

    microprocessor.acceptOperation(anIf)
    assert(microprocessor.registerA === 1)
  }
}
