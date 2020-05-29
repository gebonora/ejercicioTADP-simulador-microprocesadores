abstract class Instruction{
  def visitMicroprocessor(microprocessor: Microprocessor) : Unit
  def print() : String
}