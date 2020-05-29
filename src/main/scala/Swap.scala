class Swap extends Instruction {
  override def visitMicroprocessor(microprocessor: Microprocessor): Unit = {
    val aux = microprocessor.registerB
    microprocessor.registerB = microprocessor.registerA
    microprocessor.registerA = aux
  }

  override def print(): String = "SWAP"
}
