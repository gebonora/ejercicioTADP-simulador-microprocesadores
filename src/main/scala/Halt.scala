class Halt extends Instruction {
  override def visitMicroprocessor(microprocessor: Microprocessor): Unit = throw new Exception("Halt program")

  override def print(): String = "HALT"
}
