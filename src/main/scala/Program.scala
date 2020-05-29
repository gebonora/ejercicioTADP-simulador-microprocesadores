class Program(var instructionList: List[Instruction]) {

  def execute(microprocessor: Microprocessor): Unit = instructionList.foreach(
    instruction => instruction.visitMicroprocessor(microprocessor)
  )

  def print: String = this.instructionList.foldLeft("") { (acc, instruction) => acc + "," + instruction.print }.drop(1)

  def simplifyHalt = {
    val index = this.instructionList.map { (instruction) => instruction.print() }.indexOf("HALT") + 1
    instructionList = this.instructionList.take(index)

  }

  def simplifyIf = { // TODO: terminar esta funcion y el simplify store, load, swap
    var list = this.instructionList.map { (instruction) => instruction.print() }.filter { (ins) => ins.startsWith("IF") }
  }

  def simplifyStore ={}

  def simplifyLoad = {}

  def simplifySwap = {}
}
