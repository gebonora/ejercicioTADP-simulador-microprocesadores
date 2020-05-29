class Load(var address: Int) extends Instruction {
  override def visitMicroprocessor(microprocessor: Microprocessor): Unit =
    microprocessor.registerA = microprocessor.memory(0)

  override def print(): String = "LOAD[" + this.address + "]"
}
