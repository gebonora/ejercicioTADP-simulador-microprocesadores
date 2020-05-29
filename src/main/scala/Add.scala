class Add extends Instruction {
  override def visitMicroprocessor(microprocessor: Microprocessor): Unit = {
    microprocessor.registerA += microprocessor.registerB
  }

  override def print(): String = "ADD"
}
