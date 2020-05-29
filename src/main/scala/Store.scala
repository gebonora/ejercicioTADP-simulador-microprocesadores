class Store(var address: Int) extends Instruction {
  override def visitMicroprocessor(microprocessor: Microprocessor): Unit =
    microprocessor.memory = microprocessor.memory.updated(this.address, microprocessor.registerA)

  override def print(): String = "STORE[" + this.address + "]"
}
