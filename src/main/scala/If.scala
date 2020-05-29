class If(sub: Program) extends Instruction {
  override def visitMicroprocessor(microprocessor: Microprocessor): Unit = {
    if (microprocessor.registerA == 0)
      sub.execute(microprocessor)
  }

  override def print(): String = "IF[" + this.sub.print + "]"
}
