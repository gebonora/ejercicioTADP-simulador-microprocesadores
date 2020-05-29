

class Microprocessor() {
  var registerA: Int = 0
  var registerB: Int = 0
  var memory: List[Int] = List.fill(128)(0)

  def acceptOperation(instruction: Instruction): Unit = instruction.visitMicroprocessor(this)
}