package forkjoin

import net.sf.jtreemap.swing.TreeMapNode
import net.sf.jtreemap.swing.TreeMapNodeBuilder
import static groovyx.gpars.GParsPool.runForkJoin
import static groovyx.gpars.GParsPool.withPool

class ForkjoinController {
    def model
    def view
    private TreeMapNodeBuilder nodeBuilder

    def start = {
        edt {
            model.busy = true
            // model.rootNode.removeAllChildren()
        }
        
        final List numbers = new ArrayList(model.problemSize..1)
        nodeBuilder = new TreeMapNodeBuilder()
        TreeMapNode root = nodeBuilder.buildBranch('root', null)
        TreeMapNode nums = nodeBuilder.buildBranch(numbers.toString(), root)
        view.treemap.root = nodeBuilder.root
        withPool(model.numThreads) {
            /*
            def sorted = runForkJoin(numbers, 0, 0, topLabel) {nums, row, column, label ->
                def colorIndex = setLabelColor(label, threadColor())
                switch (nums.size()) {
                    case 0:
                    case 1:
                        return finishTask(label, nums) //store own result
                    case 2:
                        if (nums[0] <= nums[1]) {
                            return finishTask(label, nums)     //store own result
                        }
                        else {
                            return finishTask(label, nums[-1..0])   //store own result
                        }
                    default:
                        def splitList = split(nums)
                        def label1 = createLabel(row + 1, column, splitList[0])
                        def label2 = createLabel(row + 1, column + splitList[0].size(), splitList[1])
                        setLabelColor(label, COLOR_WAIT)
                        forkOffChild splitList[0], row + 1, column, label1
                        final def result = runChildDirectly(splitList[1], row + 1, column + splitList[0].size(), label2)
                        return finishTask(label, merge(label, result, * childrenResults));       //use results of children tasks to calculate and store own result

                }
            }*/
            execSync {
                model.busy = false
            }
        }
    }
}
