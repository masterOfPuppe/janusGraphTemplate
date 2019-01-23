import org.apache.hadoop.hbase.HBaseTestingUtility
import org.janusgraph.core.JanusGraphFactory
import org.scalatest.{BeforeAndAfterAll, MustMatchers, WordSpec}

class JanusGraphSpec extends WordSpec with MustMatchers with BeforeAndAfterAll {

  private val hbaseUtil = new org.apache.hadoop.hbase.HBaseTestingUtility()

  override protected def beforeAll(): Unit = {
    super.beforeAll()
    val _ = hbaseUtil.startMiniCluster(1)
  }

  override def afterAll(): Unit = {
    hbaseUtil.shutdownMiniCluster()
  }

  "A simple test" must {
    "pass" in {

      val builder = JanusGraphFactory.build.
        set("storage.backend", "hbase").
        set("storage.hostname", "localhost").
        set("storage.hbase.ext.hbase.zookeeper.property.clientPort", s"${hbaseUtil.getConfiguration.get("hbase.zookeeper.property.clientPort")}")

      val graph = builder.open()

      val j = graph.addVertex()
      j.property("name", "pippo")
      graph.tx().commit()
    }
  }
}
