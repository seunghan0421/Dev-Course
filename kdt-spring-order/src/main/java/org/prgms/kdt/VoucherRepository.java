package org.prgms.kdt;

import java.util.Optional;
import java.util.UUID;

public interface VoucherRepository {
	Optional<Voucher> findById(UUID voucherId);
}