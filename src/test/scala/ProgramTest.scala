import org.scalatest.FunSuite

class ProgramTest extends FunSuite {
  var add: Add = new Add
  var mul: Mul = new Mul
  var swap: Swap = new Swap
  var load: Load = new Load(43)
  var store: Store = new Store(24)
  var anIf: If = new If(new Program(List(add, mul, store)))
  var halt: Halt = new Halt

  test("Testing the program.print fuction, with a printf") {
    var program = new Program(List(add, mul, swap, load, store, anIf, swap, add))
    var string = program.print

    printf(string)
  }

  test("Program with Halt, expects exception") {
    var program = new Program(List(add, mul, halt, swap, load, store, anIf, swap, add))
    var microprocessor: Microprocessor = new Microprocessor
    microprocessor.registerA = 20
    microprocessor.registerB = 1

    intercept[Exception] {
      program.execute(microprocessor)
    }
    assert(microprocessor.registerA === 21)
  }

  test("simplify halt") {
    var program = new Program(List(add, mul, halt, swap, load, store, anIf, halt, swap, add))

    program.simplifyHalt
    assert(program.instructionList === List(add, mul, halt))
  }
}