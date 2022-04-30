package ca.harneev

import com.auto.brochure.repository.datasource.RetrofitApiService
import org.junit.runner.RunWith
import org.mockito.*
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

/**
 * @author Harneev Sethi
 */
@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE)
class PresenterTest {

    @Mock
    lateinit var service: RetrofitApiService

    @Mock
    lateinit var view: ViewContract

    lateinit var presenter: Presenter


}