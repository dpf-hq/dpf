import sys

sys.path.append('.')
import dpf

g = dpf.Graph()

n1 = g.createNode("n1")
n2 = g.createNode("n2")

g.createArrow("a1", n1, n2)


print g
print g.getNodes()
print g.getArrows()

dpf.save("test.xmi", g)
